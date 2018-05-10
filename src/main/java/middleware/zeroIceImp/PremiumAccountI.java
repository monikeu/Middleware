package middleware.zeroIceImp;

import Client.CreditDateRange;
import Client.CreditInfo;
import Client.CurrencyType;
import Client.PremiumAccount;
import com.zeroc.Ice.Current;

import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;

public class PremiumAccountI extends StandardAccountI implements PremiumAccount {
    public PremiumAccountI(ConcurrentHashMap<CurrencyType, Float> currencyRates, float accountState, String firstName, String lastName, String pesel) {
        super(currencyRates,accountState, firstName, lastName, pesel);
    }

    @Override
    public CreditInfo getCredit(CurrencyType desiredCurrency, float desiredAmount, CreditDateRange creditDateRange, Current current) {

        if(currencyRates.get(desiredCurrency) == null){
            return new CreditInfo(desiredCurrency, -1);
        }

        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if((currentYear > creditDateRange.year) || (currentYear == creditDateRange.year && currentMonth >= creditDateRange.month)) {
            return new CreditInfo(desiredCurrency, -2);
        }

        float desiredAmountInDesiredCurrency = desiredAmount *1.2f / currencyRates.get(desiredCurrency);

        float monthRate = desiredAmountInDesiredCurrency / ((creditDateRange.year - currentYear) * 12 + creditDateRange.month - currentMonth);

        return new CreditInfo(desiredCurrency, monthRate);

    }
}
