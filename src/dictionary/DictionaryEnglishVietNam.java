package read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DictionaryEnglishVietNam {

    public static void main(String[] args) throws FileNotFoundException {

        DictionaryEnglishVietNam dictionaryEnglishVietNam = new DictionaryEnglishVietNam();
        //Trie tree = new Trie();
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("----------------------------------------------------------------------MENU---------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\tWelcome To Dictionary Program English-VietNam\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                    "1. Program Translate Dictionary Eng-Vie. \n" +
                    "0. Exist Program.\n" +
                    "Enter Your Option: ");

            option = scanner.nextInt();

            if (option == 1) {
                dictionaryEnglishVietNam.findWordAndTrans("D:\\DictionaryProject\\DictionaryProject\\src\\dictionaryproject\\dictionary.txt");
            }
        } while (option != 0);
    }



    public void findWordAndTrans(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            Trie trie = new Trie();
            String line;
            String word = "";
            String mean = "";

            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    if (line.startsWith("@")) {

                        mean = "";

                        if (line.indexOf("/") > -1) {
                            word = line.substring(1, line.indexOf("/"));
                        } else {
                            word = line.substring(1, line.length());
                        }

                    }
                    if (line.startsWith("*") || line.startsWith("-") || line.startsWith("+") || line.startsWith("@")) {
                        if (line.startsWith("@")) {
                            mean += line.substring(1, line.length()) + "\n";

                        } else {
                            mean += line + "\n";
                        }

                    }

                    if (line.startsWith("\ufeff@")) {
                        word = line.substring(2, line.indexOf("/"));
                    }
                    trie.insert(word.trim(), mean);
                }
            }

            String dictionary;
            int choice = 1;

            do {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Typing The Word To Translate: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t > Back");
                dictionary = scanner.nextLine();

                if (!dictionary.equals(">")) {
                    if (trie.contain(dictionary) != null) {
                        System.out.println(trie.contain(dictionary).description);
                    }
                    if (trie.contain(dictionary) == null) {
                        System.out.println(dictionary + "\t\t\t\t\t\t\t\t Not found this in Dictionary Program. Make sure you enter standing! ");
                    }
                }
                if (dictionary.equals(">")) {
                    choice = 0;
                }
            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
