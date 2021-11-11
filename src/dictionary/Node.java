package read;

import java.util.TreeMap;

public class Node {

    public String description;
    public TreeMap<Character, Node> next;

    public Node(String description) {
        this.description = description;
        next = new TreeMap<>();
    }
    public Node() {
     this(null);
    }
}

