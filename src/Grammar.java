import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/*--Program and Code by Sattyik Kundu--*/
public class Grammar {

	private String startSym = "";
	private HashMap<String, List<String>> gMap = 
			new HashMap<String, List<String>>();

	
	public void load(String filename) { 
		
   /*--read data from the file named filename, reading the start-symbol 
	   and the set of rules for non-terminals into the current grammar object. 
	   If the file is invalid, this method should print an error message 
	   and halt the program. */


		try {
			String fileName1 = System.getProperty("user.dir") + "/" + filename;
			File file = new File(fileName1);  
			Scanner scan = new Scanner(file); 

			String line;

			while (scan.hasNext()) {

				String nonTerminal = ""; //this is a key
				
				List<String> productions = new ArrayList<String>();//hold productions in here 

				while (nonTerminal.equals("")) {
					line = scan.nextLine().trim();
					if (line.indexOf("{") == 0) {
						line = scan.nextLine().trim();
						if (line.startsWith("<") && line.endsWith(">")) {
							nonTerminal = line; 
							
							String bare = nonTerminal.replaceAll("[<,>]","").trim();
							if("start".equals(bare.toLowerCase())) {
								this.setStartSymbol(nonTerminal);
							}
						}
					}
				}

				line = scan.nextLine().trim();
				while (!line.equals("}")) {
					productions.add(line);
					line = scan.nextLine().trim();
				}
				gMap.put(nonTerminal, productions);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getStartSymbol() {
		//-- returns the start-symbol for the current grammar
		return startSym;
	}

	public void setStartSymbol(String sym) {
		//-- sets the start-symbol for the current grammar
		this.startSym = sym;
	}

	public void addProduction(String nonTerminal, String prod) {
		//-- add a new production prod to the end of the list of 
		//  productions for the non-terminal. 
		//  If the non-terminal is not yet a key in the map, 
		//  creating a list with this 
		//  one production and put it into the map.
		if (gMap.containsKey(nonTerminal)) {
			List<String> products = gMap.get(nonTerminal);
			products.add(prod);
			gMap.put(nonTerminal, products);
		}
		else {
			List<String> newProduction = new ArrayList<String>();
			newProduction.add(prod);
			gMap.put(nonTerminal, newProduction);
		}
		//System.out.println(GrammarMap);
	}

	public List<String> getProductionList(String nonTerminal) {
		//-- return the list of productions for 
		//   the given non-terminal
		List<String> productions = gMap.get(nonTerminal);
		return productions;
	}

	public String getRandProduction(String nonTerminal) {		
		//-- return a randomly chosen production from the 
		//   list of productions for the given non-terminal
        
		List<String> products = gMap.get(nonTerminal);
		int spaces = products.size() ;
		//System.out.println(spaces);
		int randomSpace = (int) (Math.random() * spaces) ;
		String production = products.get(randomSpace);
		return production;
	}


	public void clear() {
		gMap.clear();
	}
}
