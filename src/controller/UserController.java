package controller;

import java.util.HashMap;
import model.Account;
import repository.UserRepository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class UserController extends Menu<Account> {

    static String[] mc = {"Create a new account", "Login system", "Exit"};
    Account acc;
    UserRepository ur;
    HashMap<String, Account> uMap;

    public UserController() {
        super("====== USER MANAGEMENT SYSTEM ======", mc);
        acc = new Account();
        ur = new UserRepository();
        uMap = new HashMap<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.println("------- Create Account -------");
                ur.addAcount(uMap, acc);
                break;
            case 2:
                System.out.println("------- Login -------");
                ur.find(uMap, acc);
                break;
            case 3:
                System.out.println("Closed...");
                System.exit(0);
            default:
                System.out.println("Choose again.");
                break;
        }
    }
}
