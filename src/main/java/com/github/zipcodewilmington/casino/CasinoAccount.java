package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private static String name;
    private static String password;

    private static int balance = 100;

    public CasinoAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getBalance(){
        return balance;
    }

    public static void setBalance(int balance){
        CasinoAccount.balance = balance;
    }

    @Override
    public String toString() {
        return "CasinoAccount{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
