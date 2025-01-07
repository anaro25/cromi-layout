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
	Double freq;
	ArrayList<Node> children;
	Node parent;
	int siblingIdx;

	public Node(Double freq) {
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
}

class LeafNode extends Node {
	Content content;
	ArrayList<Symbol> path;

	public LeafNode(Double freq) {
		super(freq); // Call super's constructor
		content = new Content(null, this);
		path = new ArrayList<>();
	}
	
	public void buildPath(Node root) {
		Node node = this;
		
		while (node != root) {
			path.add(0, node.symbol); // insert at start of list
			node = node.parent;
		}
	}
	
	public String getStrPath() {
		String strPath = "";
		
		for (Symbol symbol : path) {
			strPath += String.valueOf(symbol.letterName);
		}
		return strPath;
	}
}
