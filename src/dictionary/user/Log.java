package dictionary.admin;

import java.util.Scanner;

import static dictionary.menu.Menu.*;
import static dictionary.utils.TEXTUtils.*;
import static dictionary.utils.ValidateUtils.*;

public class Log {

    public void createAccount() {
        int id = (int) Math.floor(((Math.random() * 899999) + 100000));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:_");
        String name = sc.nextLine();
        while (!isNameValid(name)) {
            System.out.println("Invalid name. please retying!");
            name = sc.nextLine();
        }
        System.out.println("Enter pass word:_");
        String pass = sc.nextLine();
        while (!isPasswordValid(pass)) {
            System.out.println("Invalid password. please retyping!");
            pass = sc.nextLine();
        }
        emailOrPhoneMenu();
        int choice = sc.nextInt();
        sc.nextLine();

        String email_phone;
        switch (choice) {
            case 1:
                System.out.println("Typing your email:_");
                email_phone = sc.nextLine();
                while (!isEmailValid(email_phone)) {
                    System.out.println("Invalid email. please retyping!");
                    email_phone = sc.nextLine();
                }
                break;
            case 2:
                System.out.println("Typing your phone:_");
                email_phone = sc.nextLine();
                while (!isPhoneValid(email_phone)) {
                    System.out.println("Invalid email. please retyping!");
                    email_phone = sc.nextLine();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        System.out.println("Typing your address:_");
        String address = sc.nextLine();
        registerMenu();

        int choice1 = sc.nextInt();
        switch (choice1) {
            case 1:
                User admin = new User(id, name, pass, email_phone, address);
                readAccount();
                listAdmin.add(admin);
                saveAccount();
                break;
            case 0:
                break;
            default:
                reportMenu();
        }
    }

    public User signIn() {
        readAccount();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account's name:_");
        String name = sc.nextLine();
        System.out.println("Enter your pass word:_");
        String pass = sc.nextLine();
        for (User admin : listAdmin) {
            if (name.equals(admin.getName()) && pass.equals(admin.getPass())) {
                return admin;
            }
        }
        return null;
    }

    public void account() {
        Scanner sc = new Scanner(System.in);
        loginRegisMenu();
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                User admin = signIn();
                if (admin != null) {
                    System.out.println(admin);
                } else {
                    loginWrongMenu();
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            createAccount();
                            break;
                        case 0:
                            break;
                        default:
                            reportMenu();
                    }
                }
                break;
            case 2:
                createAccount();
                break;
            case 0:
                break;
            default:
                reportMenu();
        }
    }
}
