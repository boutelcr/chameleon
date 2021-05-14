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
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

	public static ArrayList<String> readFile(String fileName) {
		ArrayList<String> data = new ArrayList<String>();
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				String lineData = myReader.nextLine();
				System.out.println(lineData);
				data.add(lineData);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
//			e.printStackTrace();
		}
		return data;
	}
}
