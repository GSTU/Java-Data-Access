package com.nesterione.gstu.jdbc;

import com.nesterione.gstu.jdbc.DBL.DBContext;
import com.nesterione.gstu.jdbc.Entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

/**
 * Created by igor on 08.11.2014.
 */
public class Main {

    //CTRL + Shift + F10
   public static void printMenu() {
        System.out.println("1 - Show all records");
        System.out.println("2 - Add new record");
        System.out.println("3 - Update record by id");
        System.out.println("4 - Delete record by id");
        System.out.println("5 - Details record by id");
        System.out.println("0 - Exit");
    }

    private static void actionShowAll(DBContext service) {
        System.out.println();
        System.out.println("All users");
        for(User user : service.getAll()) {
            System.out.printf("%d %s %s %s\n",user.getId(), user.getUserName(), user.getUserLogin(), user.getUserPassword());
        }
        System.out.println();
    }

    private static void actionAddRecord(DBContext service) {
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

    public static void action(DBContext service, int action) {
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

        ApplicationContext context =
                new ClassPathXmlApplicationContext("file:src/main/java/com/nesterione/gstu/jdbc/Beans.xml");

        DBContext userDBContext =
                (DBContext)context.getBean("dBContext");


        int inputVal = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            inputVal = scanner.nextInt();
            action(userDBContext, inputVal);
        } while (inputVal!=0);
    }

}
