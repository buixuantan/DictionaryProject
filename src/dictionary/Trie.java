package read;
public class Trie {


    public Node root ;


    public Trie() {
        root = new Node();
    }

    public void insert(String word, String val) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.description = val;
    }

    public Node contain(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return null;
            }
            cur = cur.next.get(c);
        }
        return cur;
    }
}

