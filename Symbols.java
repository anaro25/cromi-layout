package x;
import java.util.ArrayList;

public class Symbols {
    
    static String[] symbols = {"a","b","c","d","e","f","g","h","i","j"};
    static double[] symbolFreqs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    // breadth-first traversal
    public static void assignSymbols(Tree myTree) {
        if (myTree.root == null) {
            return; // Tree is empty
        }

        ArrayList<Node> currentLevel = new ArrayList<>();
        currentLevel.add(myTree.root);

        while (!currentLevel.isEmpty()) {
            ArrayList<Node> nextLevel = new ArrayList<>();
            for (Node node : currentLevel) {
                if (node != myTree.root) { // exclude root
                    System.out.println(node.freq);
                }
                
                nextLevel.addAll(node.children);

                // Check if this node is the last child of its parent
                if (node.isLastSibling()) {
                    System.out.println(); // Print a newline
                }
            }
            currentLevel = nextLevel; // Move to the next level
        }
    }
}

