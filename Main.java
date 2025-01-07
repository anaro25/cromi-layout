package x;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Tree myTree = new Tree(new Node(null));
		
		Init.initRootChildren(myTree, InitData.b);
		Huffman.createHuffmanTree(myTree.root);
		
		Main.buildCromi(myTree);
	}
	
	private static void buildCromi(Tree myTree) {
		Builder.buildLevelOrderSiblings(myTree);
		// Test.printLevelOrderSiblings(); // success
		// Test.printContentList(); // success
		

		//SymbolAssigner.assignSymbols();
		
		
		//ContentAssigner.assignContents();
	}
}
