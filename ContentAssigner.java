package x;
import java.util.ArrayList;

public class ContentAssigner {
	static ArrayList<Content> contentList = new ArrayList<>();
}

class Content {
	String name;
	double freq;
	
	public Content(String name) {
		this.name = name;
	}
	
	public void setFreq(double freq) {
		this.freq = freq;
	}
}