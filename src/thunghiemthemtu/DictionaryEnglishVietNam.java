package dictionary;

import dictionary.dataStructure.Trie;
//import dictionary.treeStructure.Trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static dictionary.menu.Menu.mainMenu;
import static dictionary.menu.Menu.transMenu;

public class DictionaryEnglishVietNam {

    public static void main(String[] args) throws FileNotFoundException {

        DictionaryEnglishVietNam dictionaryEnglishVietNam = new DictionaryEnglishVietNam();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            mainMenu();
            option = scanner.nextInt();

            if (option == 1) {
                dictionaryEnglishVietNam.findWordAndTrans("D:\\DictionaryProject\\DictionaryProject\\src\\dictionary\\data\\dictionary.txt");
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

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Trie trie = new Trie();
            String line;
            String word = "";
            String mean = "";

            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() > 0) {
                    if (line.startsWith("@")) {
                        mean = "";
                        if (line.indexOf("/") > -1) {
                            word = line.substring(1, line.indexOf("/"));
                        } else {
                            word = line.substring(1, line.length());
                        }
                    }

                    if (line.startsWith("*") || line.startsWith("-") || line.startsWith("+") || line.startsWith("@") || line.startsWith("=")) {
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
                transMenu();
                dictionary = scanner.nextLine();

                if (!dictionary.equals(">")) {
                    if (trie.contain(dictionary) != null) {
                        if (trie.contain(dictionary).description == null) {
                            System.out.println("not find!");
                        } else {
                            System.out.println(trie.contain(dictionary).description);
                        }
                        // System.out.println(trie.contain(dictionary).description);
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
