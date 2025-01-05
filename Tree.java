package x;

import java.util.ArrayList;

public class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public int getHeight() {
        return root.getHeight();
    }
}

class Node {
    Symbol symbol;
    double freq;
    ArrayList<Node> children;
    Node parent;
    int siblingIdx;

    public Node(double freq) {
        this.freq = freq;
        children = new ArrayList<>();
        parent = null; // Initialize parent as null
    }

    public void addChild(Node child) {
        child.parent = this; // Set parent of the child
        children.add(child);
    }

    public void addChildren(ArrayList<Node> children) {
        // Add in reverse, since children are ascending
        for (int i = 0; i < children.size(); i++) {
            Node child = children.get((children.size()-1) - i);
            child.parent = this; // Set parent of each child
            child.siblingIdx = i;
            this.children.add(child);
        }
    }

    public void insertChildSorted(Node newChild) {
        newChild.parent = this; // Set parent of the new child
        int i = 0;
        while (i < children.size() && newChild.freq <= children.get(i).freq) {
            i++;
        }
        children.add(i, newChild); // Insert at the appropriate position
    }

    public int getHeight() {
        if (children.isEmpty()) {
            return 1; // A node without children has height 1
        }

        int maxHeight = 0;
        for (Node child : children) {
            maxHeight = Math.max(maxHeight, child.getHeight());
        }
        return maxHeight + 1; // Add 1 for the current node
    }
    /*
    public ArrayList<Symbol> getPath(Node root, Node node) {
        ArrayList<Symbol> path = new ArrayList<>();
        Node currentNode = node;
        
        while (currentNode != root) {
            path.add(0, currentNode.symbol); // insert at start
            currentNode = currentNode.parent;
        }
    }
    */
}

class LeafNode extends Node {
    String content; // Meaning (temporarily 001, etc.)
    ArrayList<Node> path;

    public LeafNode(double freq, String content) {
        super(freq); // Call super's constructor
        this.content = content;
        path = new ArrayList<>();
    }
    
    public String getStrPath() {
        String strPath = "";
        
        for (Node node : path) {
            strPath += String.valueOf(node.symbol.letterName);
        }
        return strPath;
    }
}
