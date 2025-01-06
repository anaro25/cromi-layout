package x;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Main.buildHuffman(InitData.b);
		Main.buildCromi();
	}
	
	private static void buildCromi() {
		//SymbolAssigner.assignSymbols(myTree);
		
		/*
		Builder.buildLevelOrderLeafNodes();
		Builder.buildPaths(myTree.root);
		CommonSfbChecker.checkCommonSfb();
		*/
	}
	
	public static void buildHuffman(double b) {
		Tree myTree = new Tree(new Node(0)); // create rootNode with 0 freq
		Init.initRootChildren(myTree, b);
		Huffman.createHuffmanTree(myTree.root);
	}
}
