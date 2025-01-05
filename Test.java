package x;
import java.util.ArrayList;

public class Test {
		
	public static void printLevelOrder() {
		for (ArrayList<Node> siblingGroup : Data.levelOrderSiblings) {
            for (Node node : siblingGroup) {
            	System.out.print("(" + node.symbolName + ") ");
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
	
	public static void printRankedContent() {
		for (String content : Data.rankedContent) {
			System.out.println(content);
		}
	}
}