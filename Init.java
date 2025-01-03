package x;
import java.util.ArrayList;

public class Init {
	public static void setNull() {
		
		for (int row = 0; row < Data.num_keys; row++) {
            Data.freqSheet.add(new ArrayList<>());
		}
	}
		
	public static void initializeFreqs() {
		for (int x = 1; x <= Data.num_keys; x++) {
			double y = Data.p((double) x);
			
			Data.keyCodes.add(Printer.formatFunctionLabel(x)); // "001", etc.
			Data.freqSheet.get(x - 1).add(y);
		}
	}
}

class Data {
	static int num_keys = 90; // number of keys
	static int nAry = 9;
	
	static ArrayList<String> keyCodes = new ArrayList<>();
	static ArrayList<ArrayList<Double>> freqSheet = new ArrayList<>();
	
	public static double p(double x) { // Desmos exp regression
		return 10.04681 * Math.pow(0.906906, x);
	}
}