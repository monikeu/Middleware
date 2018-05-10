package middleware.banking;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import middleware.gRPC.gen.Currency;
import middleware.gRPC.gen.CurrencyGuideGrpc;
import middleware.gRPC.gen.CurrencyType;
import middleware.gRPC.gen.Price;
import middleware.zeroIceImp.AccountFactoryI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class BankServer {

    private final CurrencyGuideGrpc.CurrencyGuideStub asyncCurrencyStub;
    private final String host = "localhost";
    private int grpcPort = 50000;
    private int icePort = 50005;
    private ManagedChannel channel;
    private StreamObserver<Currency> requestObserver;
    private  ArrayList<CurrencyType>  myCurrencies= new ArrayList<>();
    private ConcurrentHashMap<Client.CurrencyType, Float> myCurrencyRates = new ConcurrentHashMap<>();
    private String bankname;



    public BankServer() {
        channel = ManagedChannelBuilder
                .forAddress(host, grpcPort)
                .usePlaintext(true)
                .build();
        asyncCurrencyStub = CurrencyGuideGrpc.newStub(channel);

        myCurrencies.add(CurrencyType.PLN);
    }

    public void start(){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // todo walidacja

            System.out.println("Type  port");
            icePort = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Type bank name");
            bankname =  bufferedReader.readLine();


            System.out.println("Type currencies, for example USD EUR separated with enter, done finishes typing");


            String line = " ";
            line = bufferedReader.readLine();
            while (!Objects.equals(line, "DONE")) {
                myCurrencies.add(CurrencyType.valueOf(line));
                line = bufferedReader.readLine();
                line=line.replace("\n", "");
            }

        } catch (IOException e) {
            System.out.println("Can't connect to the currency info server ");
        }

        getRates();

        Communicator communicator = Util.initialize();
        ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("bankAdapter" , "tcp -h localhost -p "+ icePort +":udp -h localhost -p "+ icePort);
        com.zeroc.Ice.Object factory = new AccountFactoryI(myCurrencyRates);

        adapter.add(factory, new Identity(bankname, "bank"));

        adapter.activate();
        communicator.waitForShutdown();

    }

    public void getRates() {

        StreamObserver<Price> responseObserver = new StreamObserver<Price>() {
            @Override
            public void onNext(Price price) {
                System.out.println("Received price of " + price.getCurrency().getType() + " it's " + price.getValue() + " now");
                myCurrencyRates.put(Client.CurrencyType.valueOf(price.getCurrency().getType().toString()) , price.getValue());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Finished parsing");
            }
        };

        requestObserver = asyncCurrencyStub.getRates(responseObserver);

        myCurrencies.stream().map(currencyType -> Currency.newBuilder().setType(currencyType).build()).forEach(requestObserver::onNext);

    }

    public static void main(String[] args) {
        BankServer bankServer = new BankServer();
        bankServer.start();
    }
}
