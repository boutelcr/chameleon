import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

// @Author - Sophie Baer, Desirae Webster, Caleb Boutell

public class Filereader {
	public static void main(String[] args) {
	    try {
	      File myObj = new File("whooooo.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	      
	      //This section of the code grabs the file called “whooooo.txt” 
	      //and names it myObj. Then a scanner is created for myObj called myReader.
	      //A while loop send myReader down each line and prints everything it contains. 
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	//This section ends the file reader and tells the code to print
	//“An error occurred" if there is no file with the name you entered. 

	public static ArrayList<String> readFile(String fileName) {
		ArrayList<String> data = new ArrayList<String>();
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			//Creates an array list of strings called data. Calls the file name and the file scanner. 
			
			while (myReader.hasNextLine()) {
				String lineData = myReader.nextLine();
				System.out.println(lineData);
				data.add(lineData);
			}
			//A while loop that goes through each line in the file and reads what it contains. 
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
//			e.printStackTrace();
		}
		return data;
	}
}
