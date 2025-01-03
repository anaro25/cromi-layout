package x;

// This programs aims to do Huffman coding to waste no time.
	// Just emulate the manual encoding in excel (represent as cells)
	// You can just use static arrays for clearer intuition.
// Use 1-based indexing since excel is 1-based

public class Main {
	
	public static void main (String[] args) {
		int num_keys = 90; // number of keys
		
		String[][] sheet = new String[(num_keys*2)+1][10];
			// double the row size to allow space for block migrationsc
			// represent the keys using indices (whole numbers)
			// leave a column for internal_node_names to the left of frequency column
		
		// assign x-values
		for (int row = 1; row <= num_keys; row++) {
			double x = (double) row;
			double y = Main.p(x);
			sheet[row][0] = String.format("%02d", (int) x);
			sheet[row][4] = Double.toString(y);
		}
		
		// test print
		for (int row = 1; row <= num_keys; row++) {
			System.out.print(sheet[row][0]);
			System.out.print(" |  |  |  | ");
			System.out.print(sheet[row][4]);
			System.out.println();	
		}
	}
	
	private static double p(double x) { // Desmos exp regression
		return 10.04681 * Math.pow(0.906906, x);
	}
}
