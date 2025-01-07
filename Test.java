package x;

import java.util.ArrayList;

public class Test {
		
	public static void printLevelOrderSiblings() {
		for (ArrayList<Node> siblingGroup : Data.levelOrderSiblings) {
			for (Node node : siblingGroup) {
				System.out.print(" " + Printer.formatDouble(node.freq));
				
				if (node instanceof LeafNode) {
					LeafNode leafNode = (LeafNode) node;
					
					System.out.print(" (" + leafNode.getLetterCodeWord() + ")");
					System.out.print(" [" + leafNode.content.name + "]");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void performHuffmanMultiB() {
		double b = 0.3;
		final double b_init = b;
		
		for (int i = 0; i < 15; i++) {
			double i_double = (double) i;
			b = b_init + (i_double * 0.05);
			b = Math.round(b * 100.0) / 100.0; // Round to 2 decimal places
			
			System.out.print("b: " + b);
			//Main.buildHuffman(b);
		}
	}
	
	public static void printLevelOrderLeafNodes() {
		for (LeafNode leafNode : Data.levelOrderLeafNodes) {
			System.out.print(" {" + leafNode.getLetterCodeWord() + "}");
			System.out.print(" [" + leafNode.content.name + "]");
			System.out.print(" " + Printer.formatDouble(leafNode.freq));
			System.out.println();
		}
	}
	
	public static void printContentList() {
		for (Content content : ContentAssigner.contentList) {
			System.out.println(Printer.formatDouble(content.freq) + " | " + content.name);
		}
	}
}