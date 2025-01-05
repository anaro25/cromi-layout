package x;
import java.util.ArrayList;

public class Symbols {
    
    static String[] symbols = {"a","b","c","d","e","f","g","h","i","j"};
    static double[] symbolFreqs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    // breadth-first traversal
    public static ArrayList<ArrayList<Node>> getLevelOrderSiblings(Tree myTree) {
        ArrayList<Node> currentLevel = new ArrayList<>();
        currentLevel.add(myTree.root);

        while (!currentLevel.isEmpty()) {
            ArrayList<Node> nextLevel = new ArrayList<>();
            for (Node node : currentLevel) {
                if (node != myTree.root) { // exclude root
                    System.out.println(node.siblingIdx + " | " + node.freq);
                }
                
                nextLevel.addAll(node.children);

                // Check if this node is the last child of its parent
                if (node.isLastSibling()) {
                    System.out.println(); // Print a newline
                }
            }
            currentLevel = nextLevel; // Move to the next level
        }
        
        // temp
        return new ArrayList<ArrayList<Node>>();
    }
    /*
    public static void assignSymbols(ArrayList<ArrayList<Node>> levelOrderSiblings) {
        
    }
    */
}

