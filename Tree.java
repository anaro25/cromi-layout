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
    String symbol; // "di", "da"
    double freq;
    ArrayList<Node> children;
    Node parent;

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
        for (int i = children.size() - 1; i >= 0; i--) {
            Node child = children.get(i);
            child.parent = this; // Set parent of each child
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

    public boolean isLastSibling() {
        if (parent == null) {
            return false; // Root node has no siblings
        }
        ArrayList<Node> siblings = parent.children;
        return siblings.get(siblings.size() - 1) == this; // Check if this node is the last sibling
    }
}

class LeafNode extends Node {
    String content; // Meaning (temporarily 001, etc.)
    // String codeWord; // "didati"

    public LeafNode(double freq, String content) {
        super(freq); // Call super's constructor
        this.content = content;
    }
}
