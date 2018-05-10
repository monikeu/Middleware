module Client{

    enum CurrencyType { PLN = 0, EUR = 1, USD = 2, HRK = 3, HUF = 4};

    class CreditInfo{
        CurrencyType currency;
        float ratePerMonth;
    };

    class CreditDateRange{
        short month;
        short year;
    };

    interface StandardAccount {
        float getAccountState();
    };

    interface AccountFactory {
        StandardAccount* getAccount(string pesel, string firstName, string lastName, float income);
    };

    interface PremiumAccount extends StandardAccount{
        CreditInfo getCredit(CurrencyType desiredCurrency, float desiredAmount, CreditDateRange creditDateRange);
    };

}