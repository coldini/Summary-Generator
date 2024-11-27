//This class tests the implementation of SummaryGenerator class.
//It creates a BufferedReader to read from the data file purchases.csv,
//  creates an object of SummaryGenerator,
//  uses this object to call createCountsByCountry method and pass 
//     the BufferedReader object br to this method,
//  uses this object to call showCountsByCountry method, which displays the summary.


package assign7_template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* CIS 2168 Data Structures
 *  Section Number: 003
 *  Colden Jeanmonod tur26337@temple.edu
 *  Assignment Name: Assign 11
 *  Class Name: SummaryGeneratorTest
 * A test to see if the methods in SummaryGenerator class work
 * I USED ECLIPSE IDE
 */
public class SummaryGeneratorTest {

    public static void main(String[] args) {
        try {
            //create a BufferedReader to read from file purchases.csv
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\colde\\eclipse-workspace\\Assign7-Template.zip_expanded\\Assign7-Template\\purchases.csv"));
          
            //----Assign 7 Begin ------------//

                //add your own code:
                //  create an object of SummaryGenerator
                //  use this object to call createCountsByCountry method and pass 
                //     the BufferedReader object br to this method.
                //  use this object to call showCountsByCountry  method, which displays the summary
            SummaryGenerator summaryGenerator = new SummaryGenerator();
                //Hint:
                //* Similar to the code in main() method in class IndexGenerator in the package set_map_use  posted for Lec#19.                
            summaryGenerator.createCountsByCountry(br);
            summaryGenerator.showCountsByCountry();
            //----Assign 7  End ------------//              
            
        } catch (IOException ioe) {
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        }
    }

}

