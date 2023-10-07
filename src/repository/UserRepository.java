/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.UserDao;
import java.util.HashMap;
import model.Account;

/**
 *
 * @author ASUS
 */
public class UserRepository implements IUser {

    @Override
    public void addAcount(HashMap<String, Account> uMap, Account acc) {
        if (UserDao.Instance().addAcount(uMap, acc)) {
            System.out.println("Register success.");
        } else {
            System.out.println("Username exist.");
        }
    }

    @Override
    public void find(HashMap<String, Account> uMap, Account acc) {
        if (acc.readFromFile() == null) {
            System.out.println("No account.");
            return;
        }
        if (UserDao.Instance().find(uMap, acc)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid user name or password");
        }
    }

}
