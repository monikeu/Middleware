package middleware.banking;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import middleware.gRPC.gen.Currency;
import middleware.gRPC.gen.CurrencyGuideGrpc;
import middleware.gRPC.gen.CurrencyType;
import middleware.gRPC.gen.Price;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class BankServer {

    private final CurrencyGuideGrpc.CurrencyGuideStub asyncCurrencyStub;
    private final String host = "localhost";
    private final int port = 50000;
    private ManagedChannel channel;
    private StreamObserver<Currency> requestObserver;


    public BankServer() {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext(true)
                .build();
        asyncCurrencyStub = CurrencyGuideGrpc.newStub(channel);
    }

    public void getRates() {

        ArrayList<CurrencyType> myCurrencies = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // todo walidacja
            String line = " ";

            line = bufferedReader.readLine();
            while (!Objects.equals(line, "done")) {
                myCurrencies.add(CurrencyType.valueOf(line));
                line = bufferedReader.readLine();
                line=line.replace("\n", "");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        StreamObserver<Price> responseObserver = new StreamObserver<Price>() {
            @Override
            public void onNext(Price price) {
                System.out.println("Received price of " + price.getCurrency().getType() + " it's " + price.getValue() + " now");
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

        while (true) {
            int x = 1;
        }
    }

    public static void main(String[] args) {
        BankServer bankServer = new BankServer();
        bankServer.getRates();
    }
}