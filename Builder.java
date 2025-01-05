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
}