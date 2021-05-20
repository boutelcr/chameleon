import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

// @Author - Sophie Baer, Desirae Webster, Caleb Boutell

public class SavingFiles {
	public static void main(String[] args) {
	    try {
	      File myObj = new File("fileyeet.txt");
	      // Grab the file "fileyeet" and call it myObj
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	        //if the file is created, print "File Created:" along with the name of the file.
	      } else {
	        System.out.println("File already exists.");
	        //If it already exists, print "file already exists.
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	      //If there is some other error, print "An error occurred"
	    }
	  }
	
	public static void saveFile(String fileName) {
		try {
			File myObj = new File(fileName);
			//get the name of the file we are using, call it myObj
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				//same as before
			} else {
				System.out.println("File already exists.");
			}
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	

		
	
	
}
