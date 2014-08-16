
public class RandomSentence {

	static String bigText = "";
	
	public String generate(Grammar g, String symbol) {
		// String symbol is a <xxxx> from the grammar file
	    //	bigText = "";
		
		String randomString = g.getRandProduction(symbol);
		String[] splitString = randomString.split("\\s+");
		int spaces = splitString.length;
		for (int i = 0; i < spaces; i++) {
			String segment = splitString[i];
			if (segment.startsWith("<") && segment.endsWith(">")) {
				String newSymbol = segment;
				this.generate(g, newSymbol);
			}
			else {	
				bigText += " " + segment;
			}
		}
		return bigText;
	}
	
	public String toString() {
		return bigText;
	}
	
	//Empty bigText
	public void clear(){
		bigText = "";
	}
	
	public static void main(String[] args) {
		RandomSentence r = new RandomSentence();
		Grammar g = new Grammar();
		g.setStartSymbol("<start>");
		g.load("Poem");
		r.generate(g, "<start>");
		r.toString();
		System.out.println(r.toString());
	}
}
