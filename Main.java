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
	
}