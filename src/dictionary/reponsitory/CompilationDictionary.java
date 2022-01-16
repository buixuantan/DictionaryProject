package dictionary.reponsitory;

import admin.User;
import admin.Log;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import static dictionary.menu.Menu.loginWrongMenu;
import static dictionary.menu.Menu.rulesMenu;

public class AddDictionary {

    static TreeMap<String, String> listCompilationDictionary = new TreeMap<String, String>();
    static String path = "D:\\DictionaryProject\\DictionaryProject\\src\\dictionary\\data\\dictionary.txt";
    static Set<String> setKeyDictionary;

    public static void compileDictionary() {
        Scanner sc = new Scanner(System.in);
        Log log = new Log();
        User user = log.signIn();
        if (user != null) {
            addDictionary();
        }
        loginWrongMenu();
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                log.createAccount();
                break;
            case 0:
                break;
            default:
                System.out.println("The wrong function!");
        }
    }

    public static void addDictionary() {
        Scanner sc = new Scanner(System.in);
        rulesMenu();
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                int choice2 = 0;
                do {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Typing word to add:                                  < Back");
                    String word = "@" + sc.nextLine();
                    if (word.equals("@<")) {
                        return;
                    }
                    System.out.println("Typing dictionary's mean:_                           < Back");
                    System.out.println("                                                     < Save");
                    String save = null;
                    String mean = "";
                    do {
                        mean = mean + sc.nextLine() + "\n";
                        if (mean.endsWith("<\n")) {
                            return;
                        }
                        if (mean.endsWith(">\n")) {
                            mean = mean.substring(0, mean.length() - 3);
                            System.out.println("Added your this in the program dictionary!");
                            break;
                        }
                    } while (save == null);
                    listCompilationDictionary.put(word, mean);
                    saveDictionary();
                } while (choice2 == 0);
                break;
            case 0:
                return;
        }
    }

    public static void saveDictionary() {
        File file = new File(path);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            setKeyDictionary = listCompilationDictionary.keySet();
            for (String st : setKeyDictionary) {
                bufferedWriter.newLine();
                bufferedWriter.write(st + "\n" + listCompilationDictionary.get(st));
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
