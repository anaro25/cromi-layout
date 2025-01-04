package x;
import java.util.ArrayList;

public class Cromi {
    
    public static void assignSymbols(Tree myTree) {
        // breadth-first traversal
        
        if (myTree.root == null) {
            return; // Tree is empty
        }

        ArrayList<Node> currentLevel = new ArrayList<>();
        currentLevel.add(myTree.root);

        while (!currentLevel.isEmpty()) {
            ArrayList<Node> nextLevel = new ArrayList<>();
            for (int i = 0; i < currentLevel.size(); i++) {
                Node node = currentLevel.get(i);
                System.out.println(node.freq);
                nextLevel.addAll(node.children);

                // If this is the last sibling, print a newline
                if (i == currentLevel.size() - 1) {
                    System.out.println();
                }
            }
            currentLevel = nextLevel; // Move to the next level
        }
    }
}

