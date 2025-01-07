package x;
import java.util.ArrayList;

public class CommonSfbChecker {
	
	static ArrayList<CommonSfb> commonSfbList = new ArrayList<>();
	
	public static void initCommonSfbs() {
		CommonSfbChecker.declareWordEndings();
		CommonSfbChecker.declareCommonSfbs();
		CommonSfbChecker.declareContentSpaceSfbs();
	}
	
	private static void declareWordEndings() {
		String wordStarts = "TOAWBCDSFMRHIYEGLNPUJK";
		for (int i = 0; i < wordStarts.length(); i++) {
			String secondContentStr = String.valueOf(wordStarts.charAt(i));
			CommonSfbChecker.addCommonSfb("Shift", secondContentStr);
		}
		
		String wordEndings = "ESTDNRYFLOGHAKMPUW";
		for (int i = 0; i < wordEndings.length(); i++) {
			String firstContentStr = String.valueOf(wordEndings.charAt(i));
			CommonSfbChecker.addCommonSfb(firstContentStr, "Space");
		}
	}
	
	private static void declareContentSpaceSfbs() {
		String[] firstContentStrList = {
			"Close-paren","Period","Comma","Equal","Hyphen","Slash","Semicolon",
			"Asterisk","Colon","Right-angle"
		};
		for (String firstContentStr : firstContentStrList) {
			CommonSfbChecker.addCommonSfb(firstContentStr, "Space");
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
	
	private static void addCommonSfb(String firstContentStr, String secondContentStr) {
		Content firstContent = CommonSfbChecker.getContentFromName(firstContentStr);
		Content secondContent = CommonSfbChecker.getContentFromName(secondContentStr);
		
		commonSfbList.add(new CommonSfb(firstContent, secondContent));
	}
	
	private static Content getContentFromName(String contentName) {
		for (Content content : ContentAssigner.contentList) {
			if (content.name.equals(contentName)) {
				return content;
			}
		}
		System.out.println("Error at getContentFromName()");
		return null;
	}
	
	public static boolean isAdjacent(LeafNode firstLeafNode, LeafNode secondLeafNode) {
		Symbol lastSymbolOfFirstLeafNode = firstLeafNode.path.get(
			firstLeafNode.path.size()-1);
		Symbol firstSymbolOfSecondLeafNode = secondLeafNode.path.get(0);
		
		if (lastSymbolOfFirstLeafNode == firstSymbolOfSecondLeafNode) {
			return true;
		}
		return false;
	}
	
	public static boolean isYieldCommonSfb(LeafNode leafNode) {

		for (CommonSfb commonSfb : CommonSfbChecker.commonSfbList) {
			Content firstContent = commonSfb.firstContent;
			Content secondContent = commonSfb.secondContent;
			
			if (firstContent == leafNode.content) {
				if (secondContent.leafNode != null) {
					if (CommonSfbChecker.isAdjacent(leafNode, secondContent.leafNode)) {
						return true;
					}
				}
			}
			else if (secondContent == leafNode.content) {
				if (firstContent.leafNode != null) {
					if (CommonSfbChecker.isAdjacent(firstContent.leafNode, leafNode)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

class CommonSfb {
	Content firstContent;
	Content secondContent;
	
	public CommonSfb(Content firstContent, Content secondContent) {
		this.firstContent = firstContent;
		this.secondContent = secondContent;
	}
}
