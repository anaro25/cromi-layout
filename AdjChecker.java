package x;
import java.util.ArrayList;

public class AdjChecker {
    
    static ArrayList<Adj> adjList = new ArrayList<>();
    
    public static void checkAdjFuncs(Node root) {
        Builder.buildLevelOrderLeafNodes();
        Builder.buildPaths(root);
        AdjChecker.declareWordEndings();
        
        AdjChecker.printAdj();
    }
    
    private static void declareWordEndings() {
        String wordEndings = "ESTDNRYFLOGHAKMPUW";
        
        for (int i = 0; i < wordEndings.length(); i++) {
            String firstFuncStr = String.valueOf(wordEndings.charAt(i));
            LeafNode firstFunc = AdjChecker.getLeafNodeFromContent(firstFuncStr);
            LeafNode secondFunc = AdjChecker.getLeafNodeFromContent("Space");
            
            Adj newAdj = new Adj(firstFunc, secondFunc);
            adjList.add(newAdj);
        }
    }
    
    private static void printAdj() {
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
}

class Adj {
    LeafNode firstFunc;
    LeafNode secondFunc;
    
    public Adj(LeafNode firstFunc, LeafNode secondFunc) {
        this.firstFunc = firstFunc;
        this.secondFunc = secondFunc;
    }
}
