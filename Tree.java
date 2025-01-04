package x;
import java.util.ArrayList;

public class Tree {
	Node rootNode;
	
	public Tree(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public Node getRootNode() {
		return rootNode;
	}
}

class Node {
	//String symbol; // "di", "da" 
	double freq;
	ArrayList<Node> children;
	
	public Node(double freq) {
		this.freq = freq;
		children = new ArrayList<>();
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
}

class LeafNode extends Node {
	String content; // meaning (temporarily 001, etc.)
	//String codeWord; // "didati"
	
	public LeafNode(double freq, String content) {
		super(freq); // call super's contructor
		this.content = content;
	}
}