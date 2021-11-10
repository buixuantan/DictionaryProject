package read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadEnglishWords {

    public static void main(String[] args) throws FileNotFoundException {

        ReadEnglishWords readfile = new ReadEnglishWords();
        readfile.readFileDemo("D:\\DictionaryProject\\DictionaryProject\\src\\dictionaryproject\\dictionary.txt");

    }

    public void readFileDemo(String filePath) throws FileNotFoundException {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            Trie trie = new Trie();
            String line;
            String word;

            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    if (line.startsWith("@")) {

                      if ( line.indexOf("/")>-1) {
                          word = line.substring(1,line.indexOf("/"));
                          System.out.println(word);
                       //   trie.add(word);
                      } else {
                          word = line.substring(1,line.length());
                          System.out.println(word);
                       //   trie.add(word);
                      }

                    }
                    if ( line.startsWith("\ufeff@")) {
                        word = line.substring(2,line.indexOf("/"));
                        System.out.println(word);
                     //   trie.add(word);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
