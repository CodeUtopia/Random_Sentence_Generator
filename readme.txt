The Program and Code was written by Sattyik Kundu.

Please read this file to understand how this
java program works. All the files can be 
copied and pasted into a folder in the
eclipse workspace folder. The file 
path in Eclipse should to then set
to this folder. In order to run the program,
open the .src folder in the eclipse file path
and right-click the RSG.java file and finally select
and click "run as java application.".

    This programs starts by opening with a menu with a list
  of options(which are numbered). The options are the .g files
  with the grammar constructs and variables. 
  The user then selects one of the choices by typing
  the number of the choice and then pressing ENTER.  
  The output is 5 sentences "randomly" generated using
  the selected .g file.

  
    Here is an example of how the program works:
  First, there is a choice #2 that shows the 
  file "favoriteThing.g". The user then 
  hypothetically selects #2 by typing
  "2" as input and then pressing ENTER.
  
  Inside the favoriteThing.g file, there
  is a sentence construct like this:
  "I love <noun> because it is <adjective>".
  
  Later, in the same .g file, there are values
  underneath <noun> and ones underneath <adjective> in brackets({,}).
  
  The 10 possible values for <noun> are stored in a "noun" array and
  the possible values for <adjective> are stored in an
  "adjective" array. The random function is used in a manner
  to extract a random array value from both the "noun" and "adjective"
  arrays.
   
   The sentence construct "I love <noun> because it is <adjective>." becomes
   the output sentence "I love pizza because it is tasty.".
   If the Random Sentence Generator is used again on the same favoriteThing.g file,
   the output sentence could then instead be something like
   "I love ice-cream because it is exquisite.".
   The program is set to loop a random sentence from the same selected .g file five times.
   
   After the output is fully delivered, a menu showing the available ".g" files are shown
   and the user has to select the next .g file to run.
   
   
   
   WARNING: the input must be an integer value that represent one of the selected choices
            from the menu. Otherwise, the program crashes. The source code hasn't accounted
            for improper inputs yet.			
  
  


