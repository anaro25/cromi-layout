package x;

public class Main {
	
	public static void main(String[] args) {
		double b = 0.3;
		final double b_init = b;
		
		for (int i = 0; i < 15; i++) {
			double i_double = (double) i;
			b = b_init + (i_double * 0.05);
			b = Math.round(b * 100.0) / 100.0; // Round to 2 decimal places
			
			if (b == 0.8) {
				Tree myTree = new Tree(new Node(100.0)); // create rootNode with 100% freq
				Init.initNodes(myTree, b);
				Huffman.createHuffmanTree(myTree.root);
			
				System.out.print("\n" + "b = " + b);
				System.out.print(" | height = " + (myTree.getHeight()-1) + "\n\n");
				Printer.printTree(myTree.root, 0); // initial depth = 0
			}
		}
	}
}

