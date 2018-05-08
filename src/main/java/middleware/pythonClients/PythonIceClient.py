import sys, Ice
import bank_ice

Ice.loadSlice('src/bank.ice')

currencies = {
    'PLN':bank_ice.CurrencyType.PLN,
    'EUR':bank_ice.CurrencyType.EUR,
    'USD':bank_ice.CurrencyType.USD,
    'HRK':bank_ice.CurrencyType.HRK,
    'HUF':bank_ice.CurrencyType.HUF
}

bankname = 'lala'
port = 50005

with Ice.initialize(sys.argv) as communicator:
    base = communicator.stringToProxy("bankAdapter/{0}:default -p {1}".format(bankname, port))
    accountFactory = bank_ice.AccountFactoryPrx.checkedCast(base)

    if not accountFactory:
        raise RuntimeError("Invalid proxy")

    accountPR = accountFactory.getAccount(6666,"Monika", "Darosz", 5000.0)

    base2 = communicator.stringToProxy( "standardAccount :default -p 50005")








