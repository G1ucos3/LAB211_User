/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.HashMap;
import model.Account;

/**
 *
 * @author ASUS
 */
public interface IUser {

    public void addAcount(HashMap<String, Account> uMap, Account acc);

    public void find(HashMap<String, Account> uMap, Account acc);
}
