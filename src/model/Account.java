/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Account implements Serializable{

    private String username;
    private String password;

    private HashMap<String, Account> uMap = new HashMap<>();

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Account> getuMap() {
        return uMap;
    }

    public void setuMap(HashMap<String, Account> uMap) {
        this.uMap = uMap;
    }

    public HashMap<String, Account> readFromFile() {
        File file = new File("user.dat");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return (HashMap<String, Account>) ois.readObject();

        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

    public void writeToFile(HashMap<String, Account> uMap) {
        HashMap<String, Account> newMap = readFromFile();
        if (newMap == null) {
            newMap = uMap;
        } else {
            newMap.putAll(uMap);
        }
        try {
            File file = new File("user.dat");
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
            ous.writeObject(newMap);
            ous.flush();
            ous.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
