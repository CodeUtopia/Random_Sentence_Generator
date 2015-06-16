import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*--Program and Code by Sattyik Kundu--*/

public class RSG {

	public static void main(String[] args) {
	    RSG uno = new RSG();
	    uno.main();
	}

	public static void main() {
		ArrayList<String> grammars = findGrammars();
		int number = grammars.size();

		String menu = "";
		
		//grammar files
		HashMap<Integer, String> gFiles = new HashMap<Integer, String>();

		for (int i = 0; i < number; i++) {
			int k = i + 1 ;
			gFiles.put(k, grammars.get(i));
		}

		gFiles.put((number + 1), "exit");
		
		//Get number of option for menu( value needed later)
		int gFilesSize = gFiles.size(); 

		for (int z = 1; z <= (number + 1); z++) {
			menu += z + ".)  " + gFiles.get(z) + "\n";
		}

        Scanner input = new Scanner(System.in);
		boolean loop = true;
		System.out.println(menu);
		System.out.println("\nPlease pick one Grammer file or select exit:\n");
		String input1 = input.nextLine();
		Integer choice = Integer.parseInt(input1);
		
		while (loop) {
		    String file = gFiles.get(choice);
		    if (file.equals("exit")) {
		    	System.out.println("\nYou have exited this application.");
		    	loop = false;
		    	break;
		    }
		    else if((choice >=1) || (choice <=(gFilesSize-1))){
		    	//create 5 random "sentences" from the selected file
		        for(int q = 0; q < 5; q++) {
		    		String s = "";
		    		s = createStatement(file);
		    		System.out.println(s);
		    	}
		    	System.out.println("\n\n\n" + menu);
		    	System.out.println("\nPlease pick one Grammer file(by number only) or select exit:\n");
				choice = Integer.parseInt(input.nextLine());
		    }
		    else {
		    	System.out.println("WARNING: Please pick an approriate choice number from the menu\n\n" + menu);
		    	System.out.println("\nPlease pick one Grammer file(by number only) or select exit:\n");
				choice = Integer.parseInt(input.nextLine());
		    	
		    }
		}
	}

	public static String createStatement( String fileName ) {
		Grammar mainGrammar = new Grammar();
		mainGrammar.clear();
		mainGrammar.load(fileName);
		RandomSentence sentence = new RandomSentence();
		
		//To prevent accumulation of previous random sentences.
		//This is for only showing the output for current selection
		sentence.clear();
		
		sentence.generate(mainGrammar, mainGrammar.getStartSymbol());
		return sentence.toString();
	}
	
	// create a List that contains names of all grammar files in current directory
	private static ArrayList<String> findGrammars() {
		ArrayList<String> gfiles = new ArrayList<String>();
		File dir = new File(".");  // get File object for current directory
		String[] allFiles = dir.list(); // get names of files in directory
		for (String file : allFiles) {
			if (file.endsWith(".g"))
				gfiles.add(file);
		}
		return gfiles;
	}	
}

