package x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SymbolAssigner {
    static ArrayList<Symbol> symbolList = new ArrayList<>();
    
    static { 
        char[] symbolNames = {'a','b','c','d','e','f','g','h','i','j'};
        for (int i = 0; i < symbolNames.length; i++) {
            symbolList.add(new Symbol(symbolNames[i], 0.0));
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
    public static ArrayList<ArrayList<Node>> getLevelOrderSiblings(Tree myTree) {
        ArrayList<ArrayList<Node>> levelOrderSiblings = new ArrayList<>();
        
        ArrayList<Node> currentLevel = new ArrayList<>();
        currentLevel.add(myTree.root);

        while (!currentLevel.isEmpty()) {
            ArrayList<Node> nextLevel = new ArrayList<>();
            for (Node node : currentLevel) {
                if (node != myTree.root) { // exclude root
                    
                    if (node.siblingIdx == 0) { // if first sibling
                        levelOrderSiblings.add(new ArrayList<Node>()); // add new sibling list
                    }
                    
                    // add node to the current sibling group
                    int currentSiblingGroupIdx = levelOrderSiblings.size()-1;
                    levelOrderSiblings.get(currentSiblingGroupIdx).add(node);
                }
                nextLevel.addAll(node.children);
            }
            currentLevel = nextLevel; // Move to the next level
        }
        return levelOrderSiblings;
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
                    if (currentNode.parent.symbolName == currentSymbol.name) {
                        currentSymbolIdx++;
                        isSymbolAssigned = false;
                    }
                    else {
                        // assign symbols
                        currentNode.symbolName = currentSymbol.name;
                        
                        // add current node's freq to the freq of the symbol
                            // that matches current node's symbol
                        for (int symbolIdx = 0; symbolIdx < symbolList.size(); symbolIdx++) {
                            if (currentNode.symbolName == symbolList.get(symbolIdx).name) {
                                symbolList.get(symbolIdx).freq += currentNode.freq;
                                
                                // test print
                                System.out.print("(" + currentNode.symbolName + ")");
                                System.out.print(" " + Printer.formatDouble(symbolList.get(symbolIdx).freq));
                                System.out.println();
                            }
                        }
                        currentSymbolIdx++;
                        isSymbolAssigned = true;
                    }
                } while (!isSymbolAssigned);
            }
            SymbolAssigner.sortSymbolFreqs();
            // test
            System.out.println();
        }
        return finalSumSymbols;
    }
}

class Symbol {
    char name;
    double freq;

    public Symbol(char name, double freq) {
        this.name = name;
        this.freq = freq;
    }
}
