package x;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Init {

    private static void buildContentList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("RankedContent.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	ContentAssigner.contentList.add(new Content(line));
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

	public static void initRootChildren(Tree myTree, double b) {
		Init.buildContentList();
		
		for (int x = 1; x <= InitData.numLeaves; x++) {
			Node root = myTree.root; // pass reference
			
			double y = InitData.p((double) x, b);
			double freq = (y * 100) / Init.getRawSum(b); // normalize
			
			root.addChild(new LeafNode(freq));
			
			ContentAssigner.contentList.get(x-1).setFreq(freq);
		}
	}
	
	private static double getRawSum(double b) {
		double rawSum = 0;
		
		for (int x = 1; x <= InitData.numLeaves; x++) {
			rawSum += InitData.p((double) x, b);
		}
		return rawSum;
	}
}

class InitData {
	static int numLeaves = 106; // number of keys
	static double b = 0.55; // the optimal
	
	public static double p(double x, double b) { // Desmos exp regression
		return 9.92651 * Math.pow(0.906831, b*x);
	}
}