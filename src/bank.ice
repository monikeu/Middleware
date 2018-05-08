module Client{

enum CurrencyType { EUR = 0, USD = 1, HRK = 2, HUF = 3};
enum TypeOfAccount {PREMIUM, STANDARD};

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