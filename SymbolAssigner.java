package x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SymbolAssigner {
    static ArrayList<Symbol> symbolList = new ArrayList<>();
    
    static { 
        char[] letterNames = {'a','b','c','d','e','f','g','h','i','j'};
        for (int i = 0; i < letterNames.length; i++) {
            symbolList.add(new Symbol(letterNames[i], 0.0));
        }
    }
    
    private static void sortSymbolFreqs() {
        Collections.sort(SymbolAssigner.symbolList, new Comparator<Symbol>() {
            @Override
            public int compare(Symbol s1, Symbol s2) {
                return Double.compare(s1.freq, s2.freq);  // Sorting by freq in ascending order
            }
        });
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

    public static double assignSymbols(ArrayList<ArrayList<Node>> levelOrderSiblings) {
        // test
        double finalSumSymbols = 0;
        
        for (ArrayList<Node> siblingGroup : levelOrderSiblings) {
            int currentSymbolIdx = 0;
            
            // assign symbols and add values
            for (int i = 0; i < siblingGroup.size(); i++) {
                Node currentNode = siblingGroup.get(i);
                boolean isSymbolAssigned;
                
                do {
                    Symbol currentSymbol = SymbolAssigner.symbolList.get(currentSymbolIdx);
                    
                    // if node and parent have the same symbolName
                    if (currentNode.parent.symbol == currentSymbol) {
                        currentSymbolIdx++;
                        isSymbolAssigned = false;
                    }
                    else {
                        // assign symbols
                        currentNode.symbol = currentSymbol;
                        
                        // add current node's freq to the freq of the symbol
                            // that matches current node's symbol
                        for (int symbolIdx = 0; symbolIdx < symbolList.size(); symbolIdx++) {
                            if (currentNode.symbol == symbolList.get(symbolIdx)) {
                                symbolList.get(symbolIdx).freq += currentNode.freq;
                            }
                        }
                        currentSymbolIdx++;
                        isSymbolAssigned = true;
                    }
                } while (!isSymbolAssigned);
            }
            SymbolAssigner.sortSymbolFreqs();
        }
        return finalSumSymbols;
    }
}

class Symbol {
    char letterName;
    String fingerName;
    double freq;

    public Symbol(char letterName, double freq) {
        this.letterName = letterName;
        this.freq = freq;
    }
}
