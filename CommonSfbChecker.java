package x;
import java.util.ArrayList;

public class CommonSfbChecker {
    
    static ArrayList<CommonSfb> commonSfbList = new ArrayList<>();
    
    public static void checkCommonSfb() {
        CommonSfbChecker.declareWordEndings();
        CommonSfbChecker.declareCommonSfbs();
        CommonSfbChecker.declareFunctionSpaceSfbs();
        
        CommonSfbChecker.printCommonSfb();
    }
    
    private static void declareWordEndings() {
        String wordStarts = "TOAWBCDSFMRHIYEGLNPUJK";
        for (int i = 0; i < wordStarts.length(); i++) {
            String secondFuncStr = String.valueOf(wordStarts.charAt(i));
            CommonSfbChecker.addCommonSfb("Shift", secondFuncStr);
        }
        
        String wordEndings = "ESTDNRYFLOGHAKMPUW";
        for (int i = 0; i < wordEndings.length(); i++) {
            String firstFuncStr = String.valueOf(wordEndings.charAt(i));
            CommonSfbChecker.addCommonSfb(firstFuncStr, "Space");
        }
    }
    
    private static void declareFunctionSpaceSfbs() {
        String[] listFirstFuncStr = {
            "Right-paren","Period","Comma","Equal","Hyphen","Slash","Semicolon",
            "Asterisk","Colon","Right-angle"
        };
        for (String firstFuncStr : listFirstFuncStr) {
            CommonSfbChecker.addCommonSfb(firstFuncStr, "Space");
        }
    }
    
    private static void declareCommonSfbs() {
        //CommonSfbChecker.addCommonSfb("Shift", );
        /*
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        CommonSfbChecker.addCommonSfb();
        */
        
    }
    
    private static void addCommonSfb(String firstFuncStr, String secondFuncStr) {
        LeafNode firstFunc = CommonSfbChecker.getLeafNodeFromContent(firstFuncStr);
        LeafNode secondFunc = CommonSfbChecker.getLeafNodeFromContent(secondFuncStr);
        
        commonSfbList.add(new CommonSfb(firstFunc, secondFunc));
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
            
            if (CommonSfbChecker.isAdjacent(commonSfb.firstFunc, commonSfb.secondFunc)) {
                System.out.print(" | " + "Adjacent!");
            }
            
            System.out.println();
        }
    }
    
    private static boolean isAdjacent(LeafNode firstFunc, LeafNode secondFunc) {
        Symbol lastSymbolOfFirstFunc = firstFunc.path.get(firstFunc.path.size()-1).symbol;
        Symbol firstSymbolOfSecondFunc = secondFunc.path.get(0).symbol;
        
        if (lastSymbolOfFirstFunc == firstSymbolOfSecondFunc) {
            return true;
        }
        return false;
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
