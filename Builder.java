package x;
import java.util.ArrayList;

public class Builder {
	
	public static void buildLevelOrderLeafNodes() {
        for (ArrayList<Node> siblings : Data.levelOrderSiblings) {
            for (Node node : siblings) {
                if (node instanceof LeafNode) {
                    Data.levelOrderLeafNodes.add((LeafNode) node); // typecast to LeafNode
                }
            }
        }
    }
    
    public static void buildPaths(Node root) {
        for (LeafNode leafNode : Data.levelOrderLeafNodes) {
            Node currentNode = leafNode;
            while (currentNode != root) {
                leafNode.path.add(0, currentNode);
                currentNode = currentNode.parent;
            }
        }
    }
    
    // breadth-first traversal
    public static void buildLevelOrderSiblings(Tree myTree) {
        ArrayList<Node> currentLevel = new ArrayList<>();
        currentLevel.add(myTree.root);

        while (!currentLevel.isEmpty()) {
            ArrayList<Node> nextLevel = new ArrayList<>();
            for (Node node : currentLevel) {
                if (node != myTree.root) { // exclude root
                    
                    if (node.siblingIdx == 0) { // if first sibling
                        Data.levelOrderSiblings.add(new ArrayList<Node>()); // add new sibling list
                    }
                    
                    // add node to the current sibling group
                    int currentSiblingGroupIdx = Data.levelOrderSiblings.size()-1;
                    Data.levelOrderSiblings.get(currentSiblingGroupIdx).add(node);
                }
                nextLevel.addAll(node.children);
            }
            currentLevel = nextLevel; // Move to the next level
        }
    }
}