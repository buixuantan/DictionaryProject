package dictionaryproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFileExample {

    public static void main(String[] args) throws FileNotFoundException {


        ReadFileExample readfile = new ReadFileExample();
        readfile.readFileText("src\\dictionaryproject\\dictionary.txt");

    }


    public void readFileText(String filePath) throws FileNotFoundException {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;


            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    if (line.startsWith("@") || line.startsWith("\ufeff@")) {

                        String word = line.substring(1,line.indexOf(" "));
                        System.out.println(word);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
