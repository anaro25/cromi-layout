package x;
import java.util.ArrayList;

public class Main {
	
	public static void main (String[] args) {		
		// initialize all cells to be null since you tend to leave many cells empty
		Init.setNull();
		Init.initializeFreqs();
		
		Huffman.createTree();
		
		//Printer.printSheet();
	}
}

class Huffman {
	public static void createTree() {
		// the first column of freqSheet is the topmost level of tree
		// loop until number of topmost nodes is <= nAry
		
		int numTopNodes = Data.freqSheet.size(); // initialize
		System.out.println(numTopNodes);
		
		while (numTopNodes > Data.nAry + 1) {
			// test
			numTopNodes -= 8;
			
			// after processes
			//numTopNodes = getNumTopNodes(); // update the number of top nodes
			System.out.println(numTopNodes);
		}
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