//This class generates the data summary based on the data in the file purchases.csv
// and show such summaries. 
//Currently it only counts how many times each country appears. 

package assign7_template;
/* CIS 2168 Data Structures
 *  Section Number: 003
 *  Colden Jeanmonod tur26337@temple.edu
 *  Assignment Name: Assign 11
 *  Class Name: SummaryGenerator
 * A test to see if the methods in SummaryGenerator class work
 * I USED ECLIPSE IDE
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class SummaryGenerator {

    //the delimiter comma in the data file: purchases.csv
    private final String COMMA_DELIMITER = ",";
    
    //----Assign 7 BEGIN ------------//    
    //add your code:  define a data field named countsByCountryMap, which must be a Map data structure.
    // (country-name, count)
        //Hint on Map
        //* It’s very similar to frequencies in the class CharacterCount in the package hashmap_use posted for Lec#21.
    private Map<String, Integer> countsByCountryMap;

    //add your code: define a no-argument constructor, 
    //  where you create a new HashMap or TreeMap for the data summary. 
    //  You must add the code for creating each type of Map.
    //  Then you comment the code for one type, use the other type at a time.
   
    public SummaryGenerator() {
        //add your code        
        
        //create a Map using each catory: TreeMap or HashMap for the data field: countsByCountryMap, 
        //  You must add the code for creating each type of Map.
        //  Then you comment the code for one type, use the other type at a time.    
    	countsByCountryMap = new HashMap<>();
    	//countsByCountryMap = new TreeMap<>();
        //Hints:
        // HashMap
        //  * It’s very similar to frequencies in the class CharacterCount in the package hashmap_use posted for Lec#21.
	// TreeMap
	//  * Similar to the code in the class SimpleMapTest in the package set_map_use posted for the folder: Lec19-Code-Synch-AsynchLearn-WithDetailedComment.
        

    }      
    
    //takes in a BufferedReader object that is already associated with
    //   the file purchases.csv, read the data line by line,
    //   create the country summary and save the summary entries in the summary map.
    public void createCountsByCountry(BufferedReader br) {      
        //build country summary
        List<String> purchase = new ArrayList<>();
        try {
            String line;
            //read the first line (column heading), and do not do anything with it.
            br.readLine();
            //read line by line until file reading is completed            
            while ((line = br.readLine()) != null) {
                //split values in each line using the delimiter comma,
                //  store values as String in a String array.
                String[] fields = line.split(COMMA_DELIMITER);
                //convert the array to an ArrayList
                purchase = Arrays.asList(fields);
                //System.out.println(purchase);


                if (purchase.size() > 1) {
                    String country = purchase.get(7); // Adjust the index based on your CSV structure

                    // Update the countsByCountryMap without using getOrDefault
                    if (countsByCountryMap.containsKey(country)) {
                        // If the country is already in the map, increase the count by 1
                        int currentCount = countsByCountryMap.get(country);
                        countsByCountryMap.put(country, currentCount + 1);
                    } else {
                        // If the country is not in the map, add it with a count of 1
                        countsByCountryMap.put(country, 1);
                    }
                }
                
                //----Assign 7  Continues  ------------//

                //Add your code:
                
                //get the country from the ArrayList: purchase
                //if the country is already in the data summary
                //    get the country's count, increase the count by 1,
                //    write the new summary: country, updated-count into the data summary map: countsByCountry.
                //otherwise,
                //    add the new summary entry: country, 1 into the data summary map: countsByCountry.
                
                //Hint
                //* It’s very similar to buildCharacterCount() in the class CharacterCount in the package hashmap_use posted for Lec#21.
                //* The difference is in handling the map entry type (stored format).
                 // Adjust the index based on your CSV structure

                // Update the countsByCountryMap

                //----Assign 7------------//                
                
            }
        } catch (IOException ioe) { 
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        } catch (PatternSyntaxException pse) {
            System.out.println("pattern specification error.");            
            pse.printStackTrace();
            System.exit(1);            
        }
    }
    
    //---- Assign 7 Continues ------------//
    
    //print the content of the data summary map in the format given in the sample output
    public void showCountsByCountry(){
        
        //add your code
        
        //print the heading
        //print a number of dashes


        // Use a foreach loop to iterate through the map entries
        System.out.printf("%-20s %s%n", "Country", "Count");
        System.out.println("------------------------------------------------------------");

        // Use a foreach loop to iterate through the map entries
        for (Map.Entry<String, Integer> entry : countsByCountryMap.entrySet()) {
            String country = entry.getKey(); // Get the current country
            int count = entry.getValue(); // Get the current count

            // Print the country name with a specified width
            System.out.printf("%-20s ", country); // Adjust the width as needed

            // Call printNChars to print the count as a sequence of stars
            printNChars('*', count); // Pass the character and the count to print

            // Print a new line for the next entry
            System.out.println();
        }
        //use a foreach loop
        //   do the following in each loop run
        //      get the curernt data summary entry: country, count
        //      print the country
        //      call printNChars to print the count as a sequence of stars.
        //           count of 5 means 5 stars.

        //Hints:
	//* Display data summary entry information in the format similar to the sample output
	//* You can use System.out.printf(…) method.
	//* See the class CharacterCountTest in the package hashmap_use posted for Lec#21.
        
    }
    
    //print the character ch count number of times in one line
    private void printNChars (char ch, int count) {
        
        //add your own code
    	for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
        //Hint: use a counter-controlled loop
 
    }

    //----Assign 7  End------------//    
    
}