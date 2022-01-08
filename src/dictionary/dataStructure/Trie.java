package dictionary.treeStructure;

public class Trie {

    public static Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word, String mean) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        current.description = mean;
    }

    public static Node contain(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                return null;
            }
            current = current.next.get(c);
        }
        return current;
    }
}

