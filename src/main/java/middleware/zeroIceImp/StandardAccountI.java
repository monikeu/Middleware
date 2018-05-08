package middleware.zeroIceImp;

import com.zeroc.Ice.Current;
import middleware.zerocIceGen.Client.StandardAccount;

public class StandardAccountI implements StandardAccount{

    private float accountState;
    private String firstName, lastName, pesel;

    public StandardAccountI(float accountState, String firstName, String lastName, String pesel) {
        this.accountState = accountState;
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
