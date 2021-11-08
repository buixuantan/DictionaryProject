package demotachtudien;

import java.io.*;

public class ReadDemo {
    public static void main(String[] args) throws FileNotFoundException {
        ReadDemo readDemo = new ReadDemo();
        readDemo.readFile("src\\demotachtudien\\Demo");
    }

    public void readFile(String filePath) throws FileNotFoundException {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String charater = line.substring(1,line.indexOf(" "));
                System.out.println(charater);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
