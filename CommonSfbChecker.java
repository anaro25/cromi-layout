package x;
import java.util.ArrayList;

public class CommonSfbChecker {
    
    static ArrayList<CommonSfb> commonSfbList = new ArrayList<>();
    
    public static void checkCommonSfb(Node root) {
        Builder.buildLevelOrderLeafNodes();
        Builder.buildPaths(root);
        CommonSfbChecker.declareWordEndings();
        
        CommonSfbChecker.printCommonSfb();
    }
    
    private static void declareWordEndings() {
        String wordEndings = "ESTDNRYFLOGHAKMPUW";
        
        for (int i = 0; i < wordEndings.length(); i++) {
            String firstFuncStr = String.valueOf(wordEndings.charAt(i));
            LeafNode firstFunc = CommonSfbChecker.getLeafNodeFromContent(firstFuncStr);
            LeafNode secondFunc = CommonSfbChecker.getLeafNodeFromContent("Space");
            
            CommonSfb newCommonSfb = new CommonSfb(firstFunc, secondFunc);
            commonSfbList.add(newCommonSfb);
        }
    }
    
    private static void printCommonSfb() {
        for (CommonSfb commonSfb : CommonSfbChecker.commonSfbList) {
            System.out.print("{" + commonSfb.firstFunc.getStrPath() + "}");
            System.out.print(" + ");
            System.out.print("{" + commonSfb.secondFunc.getStrPath() + "}");
            System.out.print(" | ");
            System.out.print("[" + commonSfb.firstFunc.content + "]");
            System.out.print(" + ");
            System.out.print("[" + commonSfb.secondFunc.content + "]");
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

class CommonSfb {
    LeafNode firstFunc;
    LeafNode secondFunc;
    
    public CommonSfb(LeafNode firstFunc, LeafNode secondFunc) {
        this.firstFunc = firstFunc;
        this.secondFunc = secondFunc;
    }
}
