package x;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Tree myTree = new Tree(new Node(0)); // rootNode 0 freq
		
		Main.buildHuffman(myTree, InitData.b);
		Main.buildCromi(myTree);
	}
	
	private static void buildCromi(Tree myTree) {
		Builder.buildLevelOrderSiblings(myTree);
		Builder.buildLevelOrderLeafNodes();
		Test.printLevelOrderSiblings();
		
		//SymbolAssigner.assignSymbols(myTree);
		//
		
		/*
		//Builder.buildPaths(myTree.root);
		//CommonSfbChecker.checkCommonSfb();
		*/
	}
	
	public static void buildHuffman(Tree myTree, double b) {
		Init.initRootChildren(myTree, b);
		Huffman.createHuffmanTree(myTree.root);
	}
}
