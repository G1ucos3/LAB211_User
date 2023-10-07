/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import model.Account;

/**
 *
 * @author ASUS
 */
public class Validate {

    public String checkString(String s) {
        String str = "";
        while (str.isBlank() || str.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print(s + ":");
            str = sc.nextLine();
        }
        return str;
    }

    public String checkUsername() {
        while (true) {
            String username = checkString("Enter Username");
            if (username.matches("^\\S{5}\\S*$")) {
                return username;
            }
            System.err.println("You must enter least at 5 character, and no space!");
        }
    }

    public String checkPassword() {
        while (true) {
            String username = checkString("Enter Password");
            if (username.matches("^\\S{6}\\S*$")) {
                return username;
            }
            System.err.println("You must enter least at 6 character, and no space!");
        }
    }

    public boolean checkUsernameExist(HashMap<String, Account> uMap, String username) {
        if (uMap.containsKey(username)) {
            return false;
        }
        return true;
    }
}
