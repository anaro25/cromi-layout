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

	public static void assignSymbols() {
		CommonSfbChecker.initCommonSfbs();
		ArrayList<Content> contentToAssign = ContentAssigner.contentList;
		
		for (ArrayList<Node> siblings : Data.levelOrderSiblings) {
			int symbolIdx = 0;
			
			for (Node node : siblings) {
				boolean isSymbolAssigned;
				do {
					Symbol symbol = SymbolAssigner.symbolList.get(symbolIdx);
					
					// if node and parent have the same symbolName
					if (node.parent.symbol == symbol) {
						symbolIdx++;
						isSymbolAssigned = false;
					}
					else {
						// assign symbol
						node.symbol = symbol;
						symbolIdx++;
						isSymbolAssigned = true;
						
						// if LeafNode, assign content
						if (node instanceof LeafNode) {
							ContentAssigner.assignContent((LeafNode) node, contentToAssign);
						}
					}
				} while (!isSymbolAssigned);
			}
			SymbolAssigner.sortSymbolFreqs();
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
