import DBL.Context;
import DBL.DBContext;
import DBL.MMContext;
import DBL.UserService;
import Entities.User;

import java.util.Scanner;

/**
 * Created by igor on 12.10.2014.
 */
public class DBManager {

    public static void printMenu() {
        System.out.println("1 - Show all records");
        System.out.println("2 - Add new record");
        System.out.println("3 - Update record by id");
        System.out.println("4 - Delete record by id");
        System.out.println("5 - Details record by id");
        System.out.println("0 - Exit");
    }

    private static void actionShowAll(UserService service) {
        System.out.println();
        System.out.println("All users");
        for(User user : service.getAll()) {
            System.out.printf("%d %s %s %s\n",user.getId(), user.getUserName(), user.getUserLogin(), user.getUserPassword());
        }
        System.out.println();
    }

    private static void actionAddRecord(UserService service) {
        System.out.println();
        System.out.println("Adding new User");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter userName");
        String userName = scanner.nextLine();
        System.out.println("Enter userLogin");
        String userLogin = scanner.nextLine();
        System.out.println("Enter userPassword");
        String userPassword = scanner.nextLine();

        service.create(new User(0, userName,userLogin,userPassword));

        System.out.println();
    }

    public static void action(UserService service, int action) {
        switch (action) {
            case 1:
                actionShowAll(service);
                break;
            case 2:
                actionAddRecord(service);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public static void main(String[] args) {

        Context mmContext = new MMContext();
        Context dbContext = new DBContext("jdbc:postgresql://localhost:5432/Jtest","postgres","2384340");

        //UserService service = new UserService(mmContext);
        UserService service = new UserService(dbContext);

        int inputVal = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            inputVal = scanner.nextInt();
            action(service, inputVal);
        } while (inputVal!=0);
    }
}
