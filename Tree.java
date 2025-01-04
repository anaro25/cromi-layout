package x;
import java.util.ArrayList;

public class Tree {
	Node root;
	
	public Tree(Node root) {
		this.root = root;
	}
}

class Node {
	// String symbol; // "di", "da" 
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
		for (int i = 0; i < children.size()-1; i++) {
			if (newChild.freq > children.get(i).freq) {
				children.add(i, newChild);
				break;	
			}
		}
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