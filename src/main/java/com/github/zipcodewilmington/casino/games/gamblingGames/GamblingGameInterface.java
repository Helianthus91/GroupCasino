package com.github.zipcodewilmington.casino.games.gamblingGames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public interface GamblingGameInterface {

    void playerBet();

    int calculateWinnings();

    void updateBalance();

    default void updateSelectedAccount(String accountName, String accountPassword, Integer newBalance) {
        try {
            //Make an arrayList to hold pulled accounts from the file
            List<String> updatedAccounts = new ArrayList<>();

            //Make BufferedReader to read the accounts.txt file.
            BufferedReader file = new BufferedReader(new FileReader("accounts.txt"));
            String line;

            //Read through lines, grab each accounts name and password.
            while ((line = file.readLine()) != null) {
                String[] accountInfo = line.split(",");
                String acctName = accountInfo[0];
                String acctPassword = accountInfo[1];

                //If we found the right account, update the balance.
                if (acctName.equals(accountName) && acctPassword.equals(accountPassword)) {

                    accountInfo[2] = String.valueOf(newBalance);
                }

                // Rejoin the accounts and put them into our created List.
                //This makes them ready for file rewrite.
                String updatedAccountEntry = String.join(",", accountInfo);
                updatedAccounts.add(updatedAccountEntry);
            }

            //after reading all the accounts, close reading the file.
            file.close();

            // Create a BufferedWriter so we can WRITE the files onto the accounts.txt.
            //Writes them from our updated ArrayList to the text file.
            BufferedWriter fileOut = new BufferedWriter(new FileWriter("accounts.txt"));

            //Loop through each account String in our ArrayList updatedAccounts.
            for (String updatedAccount : updatedAccounts) {

                //.write the account to the file.
                fileOut.write(updatedAccount);
                //Make new line after account write.
                fileOut.newLine();
            }

            //Close rewritten file after update.
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Problem reading/writing file.");
        }


    }
}
