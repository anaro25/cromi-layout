package x;
import java.util.ArrayList;

public class ContentAssigner {
	static ArrayList<Content> contentList = new ArrayList<>();
	
	public static void assignContent(LeafNode leafNode, ArrayList<Content> contentToAssign) {
		boolean isContentAssigned = false;
		int contentIdx = 0; // start of the queue
		do {
			Content content = contentToAssign.get(contentIdx);
			
			// assign content of leafNode (trial)
				// this allows us to check if the path made yields common sfb
			leafNode.content = content;
			
			if (CommonSfbChecker.isYieldCommonSfb(leafNode)) {
				// undo the previously assigned content of leafNode
				leafNode.content = null;
				
				contentIdx++;
				isContentAssigned = false;
			}
			else { // if doesn't yield common sfb
				// assign leafNode of content (two-way connection)
				content.leafNode = leafNode;
				
				// add the content's freq to the freq of the symbol
				for (int symbolIdx = 0; symbolIdx < SymbolAssigner.symbolList.size(); symbolIdx++) {
					if (leafNode.symbol == SymbolAssigner.symbolList.get(symbolIdx)) {
						SymbolAssigner.symbolList.get(symbolIdx).freq += leafNode.content.freq;
					}
				}
				
				contentToAssign.remove(contentIdx); // remove since it's assigned
				isContentAssigned = true;
			}
		} while (!isContentAssigned);
	}
}

class Content {
	String name;
	double freq;
	LeafNode leafNode; // two-way connection
	
	public Content(String name, LeafNode leafNode) {
		this.name = name;
		this.leafNode = leafNode;
	}
	
	public void setFreq(double freq) {
		this.freq = freq;
	}
	
	public void setLeafNode(LeafNode leafNode) {
		this.leafNode = leafNode;
	}
}