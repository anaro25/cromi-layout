package x;

class Printer {
	public static void printSheet() {
		for (int row = 0; row < Data.stringSheet.size(); row++) {
			for (int col = 0; col < Data.stringSheet.get(0).size(); col++) {
				System.out.print(" | ");
				if (col == 0) {
					System.out.print(Data.stringSheet.get(row).get(col));
				}
				else {
					if (Data.doubleSheet.get(row).get(col) == null) {
						System.out.print("   +   ");
					}
					else { // if not null
						System.out.print(Printer.formatDouble(Data.doubleSheet.get(row).get(col)));
					}
				}
				if (col == Data.stringSheet.get(0).size() - 1) { // after last cell in row
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