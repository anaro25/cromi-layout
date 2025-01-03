package x;

public class Init {
	public static void setNull() {
		
		for (int row = 0; row < Data.num_keys; row++) {
			Data.stringSheet.add(new ArrayList<>());
            Data.doubleSheet.add(new ArrayList<>());
            
			for (int col = 0; col < Data.maxCodeLength + 1; col++) {
				Data.stringSheet.get(row).add(null);
				Data.doubleSheet.get(row).add(null);
			}
		}
	}
		
	public static void initializeFreqs() {
		// assign x-values
		for (int x = 1; x <= Data.num_keys; x++) {
			double y = Data.p((double) x);
			
			Data.stringSheet.get(x - 1).set(0, Printer.formatFunctionLabel(x)); // "001", etc.
			Data.doubleSheet.get(x - 1).set(1, y);
		}
	}
}

class Data {
	static int num_keys = 90; // number of keys
	static int maxCodeLength = 5;
	
	static ArrayList<ArrayList<String>> stringSheet = new ArrayList<>();
	static ArrayList<ArrayList<Double>> doubleSheet = new ArrayList<>();
	
	public static double p(double x) { // Desmos exp regression
		return 10.04681 * Math.pow(0.906906, x);
	}
}