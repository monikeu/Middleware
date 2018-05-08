package middleware.zeroIceImp;

import com.zeroc.Ice.Current;
import middleware.zerocIceGen.Client.AccountFactory;
import middleware.zerocIceGen.Client.StandardAccountPrx;

public class AccountFactoryI implements AccountFactory{

    float minimumIncomeForPremium = 10000;

    @Override
    public StandardAccountPrx getAccount(String pesel, String firstName, String lastName, float income, Current current) {
//    todo    validate income

        if(income >= minimumIncomeForPremium){
            return new PremiumAccountI()
        }
    }

}
