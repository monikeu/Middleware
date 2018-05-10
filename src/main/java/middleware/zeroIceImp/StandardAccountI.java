package middleware.zeroIceImp;

import Client.CurrencyType;
import Client.StandardAccount;
import com.zeroc.Ice.Current;


import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class StandardAccountI implements StandardAccount {

    private float accountState;
    private String firstName, lastName, pesel;
    protected ConcurrentHashMap<CurrencyType, Float> currencyRates ;
    private Random random = new Random();


    public StandardAccountI(ConcurrentHashMap<CurrencyType, Float> currencyRates, float accountState, String firstName, String lastName, String pesel) {
        this.currencyRates = currencyRates;
        this.accountState =  random.nextFloat() * (8000) + 2000;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;

    }

    public StandardAccountI() {

    }

    @Override
    public float getAccountState(Current current) {
        return accountState;
    }
}
