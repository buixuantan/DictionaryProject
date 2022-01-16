package dictionary.reponsitory;

import java.util.TreeMap;
import java.io.*;
import java.util.*;

import static dictionary.reponsitory.Dictionary.search2;

public class InputOutputDictionary {

    static String path = "D:\\DictionaryProject\\DictionaryProject\\src\\dataUser\\data_favorite.txt";
    TreeMap<String, String> listFavorites = new TreeMap<>();
    Set<String> sets;

    public void note(String dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tying the compact mean:_                                                            * Save root mean");
        String mean = sc.nextLine();
        if (mean.equals("*")) {
            mean = search2(dictionary);
            if (mean != null) {
                listFavorites.put(dictionary, mean);
            }
        }
        listFavorites.put(dictionary, mean);
        saveWord();
    }

    public void saveWord() {
        File file = new File(path);
        try {
            if (!file.exists()) {
               file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            sets = listFavorites.keySet();
            for (String in : sets) {
                bufferedWriter.newLine();
                bufferedWriter.write(in + ": " + listFavorites.get(in));
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listFavorites() {
        File file = new File(path);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
