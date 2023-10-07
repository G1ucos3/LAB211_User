package dataAccess;

import common.Validate;
import java.util.HashMap;
import model.Account;

/**
 *
 * @author ASUS
 */
public class UserDao {

    private static UserDao instance = null;
    Validate validate = new Validate();

    public static UserDao Instance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    public boolean addAcount(HashMap<String, Account> uMap, Account acc) {
        String username = validate.checkUsername();
        if (!validate.checkUsernameExist(uMap, username)) {
            return false;
        }
        String password = validate.checkPassword();
        acc = new Account(username, password);
        uMap.put(username, acc);
        acc.writeToFile(uMap);
        return true;
    }

    public boolean find(HashMap<String, Account> uMap, Account acc) {
        String username = validate.checkUsername();
        String password = validate.checkPassword();
        if (uMap.get(username) == null) {
            return false;
        } else {
            if (!uMap.get(username).getPassword().equals(password)) {
                return false;
            }
        }
        return true;
    }
}
