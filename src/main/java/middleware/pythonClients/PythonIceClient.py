import Ice
import sys

import Client

Ice.loadSlice('bank.ice')

currencies = {
    'PLN': Client.CurrencyType.PLN,
    'EUR': Client.CurrencyType.EUR,
    'USD': Client.CurrencyType.USD,
    'HRK': Client.CurrencyType.HRK,
    'HUF': Client.CurrencyType.HUF
}

bankname = 'lala'
port = 50005

with Ice.initialize(sys.argv) as communicator:
    bankname = input("Insert your bank name")

    input_data = input("Insert port that your bank works with")
    port = int(input_data)

    base = communicator.stringToProxy("bank/{0}:tcp -h localhost -p {1}:udp -h localhost -p {1}".format(bankname, port))
    accountFactory = Client.AccountFactoryPrx.checkedCast(base)

    account = None
    end = False

    while not end:
        if not accountFactory:
            raise RuntimeError("Invalid proxy")

        try:
            input_data = input("CREATE or LOGIN or ASTATE or CREDIT or LOGOUT or END ")

            if input_data == "CREATE":
                pesel = input("Type your PESEL")
                name = input("Type your firstname")
                last_name = input("Type your lastname")
                income = float(input("Type your monthly income"))
                accountPR = accountFactory.getAccount(pesel, name, last_name, income)

                print("Account created, you can login now")

            elif input_data == "LOGIN":
                pesel = input("I need your PESEL in order to login")
                base2 = communicator.stringToProxy(
                    "account/{0}:tcp -h localhost -p {1}:udp -h localhost -p {1}".format(pesel, port))
                account = Client.StandardAccountPrx.checkedCast(base2)

                print("Loggged in")

            elif input_data == "ASTATE":
                if account is None:
                    print("You need to log in in order to check your account state")
                else:
                    print("You have {0:.2f} PLN".format(account.getAccountState()))

            elif input_data == "CREDIT":
                if account is None:
                    print("You need to log in in order to apply for a credit")
                else:
                    p_account = Client.PremiumAccountPrx.uncheckedCast(account)

                    amount = input("Specify desired amount of money")
                    amount = float(amount)
                    currency = input("Specify desired currency")
                    currency = currencies[currency]

                    date_end = input("Date end (format MM.YYYY)")
                    date_end = date_end.split(".")

                    credit_date_range = Client.CreditDateRange(int(date_end[0]), int(date_end[1]))

                    value = p_account.getCredit(currency, amount, credit_date_range)

                    if value.ratePerMonth == -1:
                        print("Your bank does not support {0} currency".format(value.currency))
                    elif value.ratePerMonth == -2:
                        print("Invalid credit date end")
                    else:
                        print("Month rate is {0} {1} ".format(value.ratePerMonth, value.currency))

            elif input_data == "END":
                end = True

            elif input_data == "LOGOUT":
                if account is None:
                    print("You're not logged in, you can't log out")
                else:
                    account = None
                    print("Logged out")


        except ValueError:
            print("You've passed incorrect value")

        except Ice.OperationNotExistException:
            print("You can't apply for a credit, you're not a premium user")
