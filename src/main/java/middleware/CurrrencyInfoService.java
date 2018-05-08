package middleware;

import io.grpc.stub.StreamObserver;
import middleware.grpc.gen.Currency;
import middleware.grpc.gen.CurrencyType;
import middleware.grpc.gen.Price;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CurrrencyInfoService{

    private ConcurrentHashMap<CurrencyType, Float> currencyRates = new ConcurrentHashMap<>();
    private Random random = new Random();
    private RandomizerThread priceRandomizer;
    private Float minX = 2.0f;
    private Float maxX = 5.0f;

    public CurrrencyInfoService(){
        initializeCurrencyRates();
        priceRandomizer = new RandomizerThread(currencyRates);
        priceRandomizer.start();
    }

    private void initializeCurrencyRates() {
        for(CurrencyType currency : CurrencyType.values()){

            currencyRates.put(currency, random.nextFloat() * (maxX - minX) + minX);
        }
    }

    public StreamObserver<Currency> getRates(StreamObserver<Price> responseObserver){
        return new StreamObserver<Currency>() {
            @Override
            public void onNext(Currency value) {
                responseObserver.onNext(getPrice(value));
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

    private class RandomizerThread extends Thread{


        private ConcurrentHashMap map;

        private RandomizerThread(ConcurrentHashMap<CurrencyType, Float> map){
            this.map = map;

        }

        @Override
        public void run(){

            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Randomizer thread was intterupted");
                }

//                for (CurrencyType currencyType: map.keySet())

                System.out.println("Randomizer thread: randomized values");
            }

        }
    }
}
