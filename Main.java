package x;

import java.util.ArrayList;

public class Main {
	
	public static void main (String[] args) {
		int num_keys = 90; // number of keys
		int maxCodeLength = 5;
		
		ArrayList<ArrayList<String>> stringSheet = new ArrayList<>();
		ArrayList<ArrayList<Double>> doubleSheet = new ArrayList<>();
		
		// initialize all cells to be null. This is important since you tend to leave many cells empty.
		for (int row = 0; row < num_keys; row++) {
			stringSheet.add(new ArrayList<>());
            doubleSheet.add(new ArrayList<>());
            
			for (int col = 0; col < maxCodeLength; col++) {
				stringSheet.get(row).add(null);
				doubleSheet.get(row).add(null);
			}
		}
		
		// assign x-values
		for (int x = 1; x <= num_keys; x++) {
			double y = p((double) x);
			
			stringSheet.get(x - 1).set(0, Formatting.formatFunctionLabel(x)); // "001", etc.
			doubleSheet.get(x - 1).set(1, y);
		}
		
		// test print
		for (int row = 0; row < stringSheet.size(); row++) {
			for (int col = 0; col < stringSheet.get(0).size(); col++) {
				if (col == 0) {
					System.out.print(" | " + stringSheet.get(row).get(col));
				}
				else {
					System.out.print(" | " + doubleSheet.get(row).get(col));
				}
			}
			System.out.println();
		}
	}
	/*
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
	*/
	
	private static double p(double x) { // Desmos exp regression
		return 10.04681 * Math.pow(0.906906, x);
	}
}

class Formatting {
	public static String formatFunctionLabel(int x) { // 001, 002, etc.
		String label = Integer.toString(x);
		int labelLength = 3;
		
		for (int i = 0; i < labelLength - label.length(); i++) {
			label = "0" + label;
		}
		return label;
	}
}