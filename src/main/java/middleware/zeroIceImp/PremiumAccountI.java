package middleware.zeroIceImp;

import com.zeroc.Ice.Current;
import middleware.zerocIceGen.Client.CreditDateRange;
import middleware.zerocIceGen.Client.CreditInfo;
import middleware.zerocIceGen.Client.CurrencyType;
import middleware.zerocIceGen.Client.PremiumAccount;

public class PremiumAccountI extends StandardAccountI implements PremiumAccount {
    @Override
    public CreditInfo getCredit(CurrencyType desiredCurrency, float desiredAmount, CreditDateRange creditDateRange, Current current) {
        return null;
    }
}
