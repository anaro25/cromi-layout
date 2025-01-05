package x;
import java.util.ArrayList;

public class Huffman {
	
	public static void createHuffmanTree(Node root) {
		int numFinalRootChildren = Data.degree + 1;
		boolean isHuffmanDone = false; // flag to avoid endless iteration
		
		while (root.children.size() >= numFinalRootChildren && !isHuffmanDone) {
			boolean isFinalIteration = (root.children.size() == numFinalRootChildren);
			
			int numLeastFreq;
			if (!isFinalIteration) numLeastFreq = Data.degree; // degree 9 as default
			else numLeastFreq = Data.degree + 1; // degree 10 for rootNode
				
			// save each least freq node in an ArrayList
				// remove root's least freq children
			ArrayList<Node> leastFreqNodes = Huffman.getLeastFreqNodes(root, numLeastFreq);
			double sumLeastFreq = Huffman.getSumNodes(leastFreqNodes);
			
			if (!isFinalIteration) {
				// create new child of root, insert in root.children ArrayList
				Node newRootChild = new Node(sumLeastFreq);
				root.insertChildSorted(newRootChild);
				
				// add the leastFreqNodes as children of Node newRootChild
				newRootChild.addChildren(leastFreqNodes);
			}
			else { // if last iteration (grouping children of rootNode)
				root.freq = sumLeastFreq;
				root.addChildren(leastFreqNodes);
				
				isHuffmanDone = true;
			}
		}
	}
	
	private static double getSumNodes(ArrayList<Node> nodes) {
		double sum = 0;
		for (Node node : nodes) {
			sum += node.freq;
		}
		return sum;
	}
	
	private static ArrayList<Node> getLeastFreqNodes(Node root, int numLeastFreq) {
		ArrayList<Node> leastFreqNodes = new ArrayList<>();
		
		for (int i = 0; i < numLeastFreq; i++) {
			int lastIdx = root.children.size() - 1;
			leastFreqNodes.add(root.children.get(lastIdx));
			
			root.children.remove(lastIdx); // remove least freq as children
		}
		return leastFreqNodes;
	}
}