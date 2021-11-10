package dictionaryproject;

import read.ReadEnglishWords;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Trie trie = new Trie();


        trie.add("ab");
        trie.add("hello");

        (new Scanner(System.in)).next();
    }
}
