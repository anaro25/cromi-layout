package x;

public class Init {

	public static void initNodes(Tree myTree) {
		for (int x = 1; x <= Data.numLeaves; x++) {
			Node root = myTree.root; // pass reference
			
			double y = Data.p((double) x);
			double freq = (y * root.freq) / Init.getRawSum(); // normalize
			
			String content = Formatter.formatContent(x);
			root.addChild(new LeafNode(freq, content));
		}
	}
	
	private static double getRawSum() {
		double rawSum = 0;
		
		for (int x = 1; x <= Data.numLeaves; x++) {
			rawSum += Data.p((double) x);
		}
		return rawSum;
	}
}

class Data {
	static int numLeaves = 90; // number of keys
	static int degree = 9; // degree-ary
	
	public static double p(double x) { // Desmos exp regression
		return 10.04681 * Math.pow(0.906906, x);
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