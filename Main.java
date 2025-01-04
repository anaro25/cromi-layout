package x;

public class Main {
	
	public static void main(String[] args) {
		Tree myTree = new Tree(new Node(100.0)); // create rootNode with 100% freq
		Init.initNodes(myTree);
		
		// Huffman.createHuffmanTree(myTree);
		
		Printer.printTree(myTree.rootNode, 0); // initial depth = 0
	}
}

