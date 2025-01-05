package x;
import java.util.ArrayList;

public class Printer {
	
	// to print tree in indentation style, use preorder traversal
    public static void printTree(Node node, int depth) { // recursive
    	int indent = 6;
        // print freq
        System.out.print(" ".repeat(depth * indent));
        System.out.print("|--(" + String.valueOf(node.symbol.letterName) + ") ");
        System.out.print(formatDouble(node.freq));

        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode) node;
            System.out.print(" [" + leaf.content + "]");
        }
        
        System.out.println();

        // Recursively print children nodes
        if (node.children != null) {
            for (Node child : node.children) {
                printTree(child, depth + 1);
            }
        }
    }
    
	public static String formatDouble(double doubleValue) {
	    int length = 6;
	    String stringValue = Double.toString(doubleValue);
	    
	    // If value is longer than the required length, truncate
	    if (stringValue.length() > length) {
	        return stringValue.substring(0, length);
	    }
	    // If value contains only spaces, return as is
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