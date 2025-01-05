package x;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Main.buildCromi(0.55);
	}
	
	public static void buildCromi(double b) {
		Tree myTree = new Tree(new Node(0)); // create rootNode with 0 freq
		Init.initRootChildren(myTree, b);
		Huffman.createHuffmanTree(myTree.root);
		SymbolAssigner.buildLevelOrderSiblings(myTree);
		SymbolAssigner.assignSymbols(Data.levelOrderSiblings);
		
		AdjChecker.initAdjChecker(myTree.root);
		AdjChecker.printAdj();
	}
}
