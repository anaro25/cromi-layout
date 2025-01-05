package x;

public class Init {

	public static void initNodes(Tree myTree, double b) {
		for (int x = 1; x <= Data.numLeaves; x++) {
			Node root = myTree.root; // pass reference
			
			double y = Data.p((double) x, b);
			double freq = (y * 100) / Init.getRawSum(b); // normalize
			
			String content = Init.formatContent(x);
			root.addChild(new LeafNode(freq, content));
		}
	}
	
	private static double getRawSum(double b) {
		double rawSum = 0;
		
		for (int x = 1; x <= Data.numLeaves; x++) {
			rawSum += Data.p((double) x, b);
		}
		return rawSum;
	}
	
	private static String formatContent(int x) { // 001, 002, etc.
		String content = Integer.toString(x);
		int maxContentLength = 3;
		
		for (int i = 0; i < (maxContentLength - content.length())+1; i++) {
			content = "0" + content;
		}
		return content;
	}
}

class Data {
	static int numLeaves = 106; // number of keys
	static int degree = 9; // degree-ary
	
	public static double p(double x, double b) { // Desmos exp regression
		return 10.05217 * Math.pow(0.906822, b*x);
	}
}