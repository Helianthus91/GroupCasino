package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {

    private List<CasinoAccount> accounts;
    private IOConsole console;

    public CasinoAccountManager(List<CasinoAccount> accounts, IOConsole console) {
        this.accounts = accounts;
        this.console = console;
    }

    public CasinoAccountManager() {
        this(new ArrayList<>(), new IOConsole(AnsiColor.YELLOW));
    }

    /**
     *
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */

    public CasinoAccount getAccount(String accountName, String accountPassword) {
       for(CasinoAccount account : accounts){
           String acctName = account.getName();
           String acctPassword = account.getPassword();

           if (acctName.equals(accountName) && acctPassword.equals(accountPassword)){
               console.println("Finding account for (%s)...", acctName);
               console.println("Account found. Welcome (%s)!", acctName);
               return account;
           }
       }
       console.println("Account not found :l");
       return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
       CasinoAccount account = new CasinoAccount(accountName, accountPassword);
       account.setBalance(100);
       console.println("Account created successfully");
       return account;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
       accounts.add(casinoAccount);
       console.println("Account added to database");
    }
}
