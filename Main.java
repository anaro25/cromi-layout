package x;
import java.util.ArrayList;

public class Main {
	
	public static void main (String[] args) {		
		// initialize all cells to be null since you tend to leave many cells empty
		Init.setNull();
		Init.initializeFreqs();
		
		Huffman.createTree();
		
		Printer.printSheet();
	}
}

class Huffman {
	public static void createTree() {
		// the first column of freqSheet is the topmost level of tree
		// loop while number of topmost nodes is > nAry + 1
		
		int numTopNodes = Data.freqSheet.size(); // initialize
		
		//while (numTopNodes > Data.nAry + 1) {
		for (int i = 0; i < 1; i++) {
			createParent();
			
			// after processes
			numTopNodes = getNumTopNodes(); // update the number of top nodes
		}
	}
	
	private static double createParent() {
		// use while loop since you don't know how many cells to traverse upwards
			// some cells might be null
		int numLeastFreq = 0;
		double sumLeastFreq = 0;
		
		while (numLeastFreq < Data.nAry) {
			int currentRow = Data.freqSheet.size() - 1 - numLeastFreq;
			Double leftmostCell = Data.freqSheet.get(currentRow).get(0);
			
			// move the row right 1 generation
			Data.freqSheet.get(currentRow).add(0, null);
			
			if (leftmostCell != null) {	
				sumLeastFreq += leftmostCell;
				
				if (numLeastFreq == Data.nAry - 1) { // if it's the last least freq
					Data.freqSheet.get(currentRow).set(0, sumLeastFreq); // set parent freq
				}		
				numLeastFreq++;
			}
		}
		return sumLeastFreq;
	}
	
	private static int getNumTopNodes() {
		int temp = 0;
		for (int row = 0; row < Data.freqSheet.size(); row++) {
			if (Data.freqSheet.get(row).get(0) != null) {
				temp++;	
			}
		}
		return temp;
	}
}