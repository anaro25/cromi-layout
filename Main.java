package x;

public class Main {
	
	public static void main(String[] args) {
		Tree myTree = new Tree(new Node(100.0)); // create rootNode with 100% freq
		Init.initNodes(myTree);
		
		Printer.printTree(myTree.getRootNode(), 0); // initial depth = 0
	}
}

class Formatter {
	public static String formatContent(int x) { // 001, 002, etc.
		String content = Integer.toString(x);
		int maxContentLength = 3;
		
		for (int i = 0; i < (maxContentLength - content.length())+1; i++) {
			content = "0" + content;
		}
		
		return content;
	}
}
