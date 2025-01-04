package x;
import java.util.ArrayList;

public class Huffman {
	
	public static void createHuffmanTree(Node root) {
		// save each least freq node in an ArrayList
			// remove root's least freq children
		ArrayList<Node> leastFreqNodes = Huffman.getLeastFreqNodes(root);
		double sumLeastFreq = Huffman.getSumNodes(leastFreqNodes);
		
		// create new child of root, insert in root.children ArrayList
		Node newRootChild = new Node(sumLeastFreq);
		//root.insertChildSorted(newRootChild);
		// test
		root.addChild(newRootChild);
		
		// add the 'displaced' ArrayList as children of Node newRootChild
	}
	
	private static double getSumNodes(ArrayList<Node> nodes) {
		double sum = 0;
		for (Node node : nodes) {
			sum += node.freq;
		}
		
		return sum;
	}
	
	private static ArrayList<Node> getLeastFreqNodes(Node root) {
		ArrayList<Node> leastFreqNodes = new ArrayList<>();
		
		for (int i = 0; i < Data.degree; i++) {
			int lastIdx = root.children.size() - 1;
			leastFreqNodes.add(root.children.get(lastIdx));
			
			root.children.remove(lastIdx); // remove least freq as children
		}
		return leastFreqNodes;
	}
}