package middleware.zeroIceImp;

import Client.AccountFactory;
import Client.CurrencyType;
import Client.PremiumAccountPrx;
import Client.StandardAccountPrx;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;


import java.util.concurrent.ConcurrentHashMap;

public class AccountFactoryI implements AccountFactory {

    float minimumIncomeForPremium = 10000;
    private ConcurrentHashMap<CurrencyType, Float> currencyRates ;

    public AccountFactoryI(ConcurrentHashMap<CurrencyType, Float> currencyRates) {
        this.currencyRates = currencyRates;
    }

    @Override
    public StandardAccountPrx getAccount(String pesel, String firstName, String lastName, float income, Current current) {

        if(income >= minimumIncomeForPremium){
            return PremiumAccountPrx.uncheckedCast(current.adapter.add(new PremiumAccountI(currencyRates,0.0f, pesel, firstName,lastName), new Identity(pesel, "account")));
        }
        else
            return StandardAccountPrx.uncheckedCast(current.adapter.add(new StandardAccountI(currencyRates,0.0f, pesel, firstName,lastName), new Identity(pesel, "account")));
    }

}
