package x;
import java.util.ArrayList;

public class Tree {
	Node root;
	
	public Tree(Node root) {
		this.root = root;
	}
	
	public int getHeight() {
        if (root == null) {
            return 0; // Empty tree
        }
        return root.getHeight();
    }
}

class Node {
	String symbol; // "di", "da" 
	double freq;
	public ArrayList<Node> children;
	
	public Node(double freq) {
		this.freq = freq;
		children = new ArrayList<>();
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	public void addChildren(ArrayList<Node> children) {
		// add in reverse, since children is ascending
		for (int i = children.size()-1; i >= 0; i--) {
			this.children.add(children.get(i));
		}
	}
	
	public void insertChildSorted(Node newChild) {
		for (int i = 0; i < children.size(); i++) {
			if (newChild.freq > children.get(i).freq) {
				children.add(i, newChild);
				break;	
			}
		}
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
}

class LeafNode extends Node {
	String content; // meaning (temporarily 001, etc.)
	// String codeWord; // "didati"
	
	public LeafNode(double freq, String content) {
		super(freq); // call super's contructor
		this.content = content;
	}
}