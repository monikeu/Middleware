package middleware.zeroIceImp;

import com.zeroc.Ice.Current;
import middleware.zerocIceGen.Client.AccountFactory;
import middleware.zerocIceGen.Client.StandardAccountPrx;

public class AccountFactoryI implements AccountFactory{

    float minimumIncomeForPremium = 10000;

    @Override
    public StandardAccountPrx getAccount(String pesel, String firstName, String lastName, float income, Current current) {
//    todo    validate income (czy > 0 itp)

        if(income >= minimumIncomeForPremium){
            return (StandardAccountPrx) new PremiumAccountI(0, firstName,lastName,pesel);
        }
        else
            return (StandardAccountPrx) new StandardAccountI(0, firstName, lastName,pesel);
    }

}
