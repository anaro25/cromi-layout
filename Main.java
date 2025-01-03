package x;

// This programs aims to do Huffman coding to waste no time.
	// Just emulate the manual encoding in excel (represent as cells)
	// You can just use static arrays for clearer intuition.
// Use 1-based indexing since excel is 1-based

public class Main {
	
	public static void main (String[] args) {
		int num_keys = 90; // number of keys
		
		String[][] sheet = new String[(num_keys*2)+1][9];
			// double the row size to allow space for block migrationsc
			// represent the keys using indices (whole numbers)
			// leave a column for internal_node_names to the left of frequency column
		sheet = formatEmptyCells(sheet.length, sheet[0].length);
		
		/*
		// assign x-values
		for (int row = 1; row <= num_keys; row++) {
			double x = (double) row;
			double y = p(x);
			sheet[row][1] = String.format("%02d", (int) x);
			sheet[row][5] = Double.toString(y);
		}
		*/
		
		// test print
		for (int row = 1; row < sheet.length; row++) {
			System.out.print("| " + sheet[row][0]);
			for (int col = 1; col <= 8; col++) {
				System.out.print(" | " + formatValue(sheet[row][col]));
			}
			
			System.out.print(" |" + "\n");
		}
	}
	
	private static String[][] formatEmptyCells(int rowSize, int colSize) {
		String[][] emptySheet = new String[rowSize][colSize];
		
	    for (int row = 0; row < rowSize; row++) {
	        for (int col = 0; col < colSize; col++) {
	            emptySheet[row][col] = "  +  "; // Set each cell to "  +  "
	        }
	    }
		return emptySheet;
	}
	
	private static String formatValue(String value) {
	    int length = 5;
	    
	    // If value is already longer than the required length, truncate it
	    if (value.length() > length) {
	        return value.substring(0, length);
	    }

	    // If value contains only spaces (empty or made of spaces), return as is
	    if (value.trim().length() == 0) {
	        return value;
	    }

	    // Pad the string with zeros (to the right) until it reaches the specified length
	    StringBuilder paddedValue = new StringBuilder(value);
	    while (paddedValue.length() < length) {
	        paddedValue.append("0");
	    }
	    return paddedValue.toString();
	}
	
	private static double p(double x) { // Desmos exp regression
		return 10.04681 * Math.pow(0.906906, x);
	}
}
