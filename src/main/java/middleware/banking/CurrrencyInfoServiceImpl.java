package middleware.banking;

import io.grpc.stub.StreamObserver;
import middleware.gRPC.gen.CurrencyGuideGrpc;
import middleware.gRPC.gen.CurrencyType;
import middleware.gRPC.gen.Price;
import middleware.gRPC.gen.Currency;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CurrrencyInfoServiceImpl extends CurrencyGuideGrpc.CurrencyGuideImplBase {

    private ConcurrentHashMap<CurrencyType, Float> currencyRates = new ConcurrentHashMap<>();
    private HashMap<CurrencyType, Set<StreamObserver<Price>>> banksInterestedIn = new HashMap<>();

    private Random random = new Random();
    private RandomizerThread priceRandomizer;
    private Float minX = 2.0f;
    private Float maxX = 5.0f;

    public CurrrencyInfoServiceImpl() {
        initializeCurrencyRates();
        initializeBanksMap();
        priceRandomizer = new RandomizerThread();
        priceRandomizer.start();

        System.out.println(currencyRates);
    }

    private void initializeBanksMap() {
        for (CurrencyType c : CurrencyType.values()

                ) {
            if (c != CurrencyType.UNRECOGNIZED) {
                banksInterestedIn.put(c, new HashSet<>());
            }
        }
    }

    private void initializeCurrencyRates() {
        for (CurrencyType currency : CurrencyType.values()) {
            if (currency != CurrencyType.UNRECOGNIZED)
                currencyRates.put(currency, random.nextFloat() * (maxX - minX) + minX);
        }

        currencyRates.put(CurrencyType.PLN, 0.0f);
    }

    @Override
    public StreamObserver<Currency> getRates(StreamObserver<Price> responseObserver) {
        return new StreamObserver<Currency>() {
            @Override
            public void onNext(Currency value) {
                // todo opis requestu
                System.out.println("Received request");
                responseObserver.onNext(getPrice(value));
                banksInterestedIn.get(value.getType()).add(responseObserver);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    private Price getPrice(Currency value) {
        Float price = currencyRates.get(value.getType());
        return Price.newBuilder().setCurrency(value).setValue(price).build();
    }

    private class RandomizerThread extends Thread {

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Randomizer thread was intterupted");
                }

                for (CurrencyType currencyType : CurrencyType.values()) {
                    if (random.nextInt(2) == 0)
                        continue;
                    if (currencyType != CurrencyType.UNRECOGNIZED && currencyType != CurrencyType.PLN) {
                        currencyRates.put(currencyType, random.nextFloat() * (maxX - minX) + minX);
                        notifyBanks(currencyType);
                        System.out.println("Randomized " + currencyType + " now it's " + currencyRates.get(currencyType));
                    }

                }

                System.out.println(currencyRates);

            }

        }
    }

    private void notifyBanks(CurrencyType currencyType) {
        for (StreamObserver<Price> bank :
                banksInterestedIn.get(currencyType)) {
            Float aFloat = currencyRates.get(currencyType);
            Price result = Price
                    .newBuilder()
                    .setCurrency(Currency
                            .newBuilder()
                            .setType(currencyType))
                    .setValue(aFloat).build();
            bank.onNext(result);
        }
    }
}

