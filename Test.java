package x;

import java.util.ArrayList;

public class Test {
		
	public static void printLevelOrderSiblings() {
		for (ArrayList<Node> siblingGroup : Data.levelOrderSiblings) {
            for (Node node : siblingGroup) {
            	System.out.print("(" + node.symbol.letterName + ") ");
                System.out.print(Printer.formatDouble(node.freq) + "\n");
            }
            System.out.println();
        }
	}
	
	public static void printSumAllNodes() {
		double sumAllNodes = 0;
		for (ArrayList<Node> siblings : Data.levelOrderSiblings) {
			for (Node node : siblings) {
				sumAllNodes += node.freq;
			}
		}
		System.out.println("sumAllNodes: " + sumAllNodes);
	}
	
	public static void printSumSymbols() {
		double sumSymbols = 0;
		for (Symbol symbol : SymbolAssigner.symbolList) {
			sumSymbols += symbol.freq;
		}
		System.out.println("sumSymbols: " + sumSymbols);
	}
	
	public static void performHuffmanMultiB() {
		double b = 0.3;
		final double b_init = b;
		
		for (int i = 0; i < 15; i++) {
			double i_double = (double) i;
			b = b_init + (i_double * 0.05);
			b = Math.round(b * 100.0) / 100.0; // Round to 2 decimal places
			
			System.out.print("b: " + b);
			Main.buildHuffman(b);
		}
	}
	
	public static void printLevelOrderLeafNodes() {
		int idx = 1;
		
		for (LeafNode leafNode : Data.levelOrderLeafNodes) {
			System.out.print(" (" + idx + ")");
			System.out.print(" {" + leafNode.getStrPath() + "}");
			System.out.print(" [" + leafNode.content + "]");
			System.out.println();
			idx++;
		}
	}
}