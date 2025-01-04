package x;

public class Init {

	public static void initNodes(Tree myTree) {
		for (int x = 1; x <= Data.numLeaves; x++) {
			Node rootNode = myTree.getRootNode(); // pass reference
			
			double y = Data.p((double) x);
			double freq = (y * rootNode.freq) / Init.getRawSum(); // normalize
			
			String content = Formatter.formatContent(x);
			rootNode.addChild(new LeafNode(freq, content));
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