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
            
			for (int col = 0; col < maxCodeLength + 1; col++) {
				stringSheet.get(row).add(null);
				doubleSheet.get(row).add(null);
			}
		}
		
		// assign x-values
		for (int x = 1; x <= num_keys; x++) {
			double y = Data.p((double) x);
			
			stringSheet.get(x - 1).set(0, Printer.formatFunctionLabel(x)); // "001", etc.
			doubleSheet.get(x - 1).set(1, y);
		}
		
		Printer.printSheet(stringSheet, doubleSheet);
	}
}

class Data {
	public static double p(double x) { // Desmos exp regression
		return 10.04681 * Math.pow(0.906906, x);
	}
}

class Printer {
	
	public static void printSheet(
		ArrayList<ArrayList<String>> stringSheet, 
		ArrayList<ArrayList<Double>> doubleSheet) {
		
		for (int row = 0; row < stringSheet.size(); row++) {
			for (int col = 0; col < stringSheet.get(0).size(); col++) {
				System.out.print(" | ");
				if (col == 0) {
					System.out.print(stringSheet.get(row).get(col));
				}
				else {
					if (doubleSheet.get(row).get(col) == null) {
						System.out.print("   +   ");
					}
					else { // if not null
						System.out.print(Printer.formatDouble(doubleSheet.get(row).get(col)));
					}
				}
				if (col == stringSheet.get(0).size() - 1) { // after last cell in row
					System.out.print(" |");
				}
			}
			System.out.println();
		}
	}
	
	public static String formatFunctionLabel(int x) { // 001, 002, etc.
		String label = Integer.toString(x);
		int maxLabelLength = 3;
		
		for (int i = 0; i < (maxLabelLength - label.length())+1; i++) {
			label = "0" + label;
		}
		
		return label;
	}
	
	public static String formatDouble(double doubleValue) {
	    int length = 7;
	    String stringValue = Double.toString(doubleValue);
	    
	    // If value is already longer than the required length, truncate it
	    if (stringValue.length() > length) {
	        return stringValue.substring(0, length);
	    }
	    // If value contains only spaces (empty or made of spaces), return as is
	    if (stringValue.trim().length() == 0) {
	        return stringValue;
	    }

	    // Pad the string with zeros (to the right) until it reaches the specified length
	    StringBuilder paddedValue = new StringBuilder(stringValue);
	    while (paddedValue.length() < length) {
	        paddedValue.append("0");
	    }
	    return paddedValue.toString();
	}
	
}