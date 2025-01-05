package x;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Main.performHuffman(0.55);
	}
	
	private static void performHuffman(double b) {
		Tree myTree = new Tree(new Node(0)); // create rootNode with 0 freq
		Init.initNodes(myTree, b);
		Huffman.createHuffmanTree(myTree.root);
		
		ArrayList<ArrayList<Node>> levelOrderSiblings = SymbolAssigner.getLevelOrderSiblings(myTree);
		SymbolAssigner.assignSymbols(levelOrderSiblings);
		
		//Printer.printLevelOrder(levelOrderSiblings);
		
		//System.out.print("\n" + "b = " + b);
		//System.out.print(" | height = " + (myTree.getHeight()-1));
		//System.out.println("\n");
		
		Printer.printTree(myTree.root, 0); // initial depth = 0
	}
	
	private static void performHuffmanMultiB() {
		double b = 0.3;
		final double b_init = b;
		
		for (int i = 0; i < 15; i++) {
			double i_double = (double) i;
			b = b_init + (i_double * 0.05);
			b = Math.round(b * 100.0) / 100.0; // Round to 2 decimal places
			
			Main.performHuffman(b);
		}
	}
}

