package dictionary.reponsitory;

import java.util.TreeMap;
import java.io.*;
import java.util.*;

public class InputOutputDictionary implements Serializable {

    static String path;
    static TreeMap<String, String> danhsachtu = new TreeMap<String, String>();

    public static void note(String dictionary) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap nghia cho tu:");
        String nghia = sc.nextLine();
        danhsachtu.put(dictionary, nghia);

        saveTu();
    }

    public static void saveTu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap duong link file:");
        path = sc.nextLine();
        File file = new File(path);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileOutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            Set<String> sets = Collections.singleton(danhsachtu.keySet()+ " " + danhsachtu.values());

            for (String in : sets) {
                oos.writeObject(in);
            }

            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void danhSachTu() {
      //  String fi = "D:\\DictionaryProject\\DictionaryProject\\src\\dataUser\\test.txt";
        File file = new File(path);
        Object ob;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            while (is.available() > 0) {
                ob = ois.readObject();
                System.out.println(ob);
            }

            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
