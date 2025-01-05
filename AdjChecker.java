package x;
import java.util.ArrayList;

public class AdjChecker {
    
    static ArrayList<Adj> adjList = new ArrayList<>();
    static String wordEndings = "ESTDNRYFLOGHAKMPUW";
    
    public static void initAdjChecker(Node root) {
        AdjChecker.buildLevelOrderLeafNodes();
        AdjChecker.buildPaths(root);
        
        for (int i = 0; i < wordEndings.length(); i++) {
            LeafNode firstFunc = AdjChecker.getLeafNodeFromContent("Space");
            String secondFuncStr = String.valueOf(wordEndings.charAt(i));
            LeafNode secondFunc = AdjChecker.getLeafNodeFromContent(secondFuncStr);
            
            Adj newAdj = new Adj(firstFunc, secondFunc);
            adjList.add(newAdj);
        }
    }
    
    private static void buildPaths(Node root) {
        for (LeafNode leafNode : Data.levelOrderLeafNodes) {
            Node currentNode = leafNode;
            while (currentNode != root) {
                leafNode.path.add(0, currentNode);
                currentNode = currentNode.parent;
            }
        }
    }
    
    public static void printAdj() {
        for (Adj adj : AdjChecker.adjList) {
            System.out.print("{" + adj.firstFunc.getStrPath() + "}");
            System.out.print(" + ");
            System.out.print("{" + adj.secondFunc.getStrPath() + "}");
            System.out.print(" | ");
            System.out.print("[" + adj.firstFunc.content + "]");
            System.out.print(" + ");
            System.out.print("[" + adj.secondFunc.content + "]");
            
            System.out.println();
        }
    }

    private static LeafNode getLeafNodeFromContent(String content) {
        for (LeafNode leafNode : Data.levelOrderLeafNodes) {
            if (leafNode.content.equals(content)) {
                return leafNode;
            }
        }
        return null;
    }
    
    public static void buildLevelOrderLeafNodes() {
        for (ArrayList<Node> siblings : Data.levelOrderSiblings) {
            for (Node node : siblings) {
                if (node instanceof LeafNode) {
                    Data.levelOrderLeafNodes.add((LeafNode) node); // typecast to LeafNode
                }
            }
        }
    }
}

class Adj {
    LeafNode firstFunc;
    LeafNode secondFunc;
    
    public Adj(LeafNode firstFunc, LeafNode secondFunc) {
        this.firstFunc = firstFunc;
        this.secondFunc = secondFunc;
    }
}
