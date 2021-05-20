import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.IOException;  // Import the IOException class to handle errors

// @Author - Sophie Baer, Desirae Webster, Caleb Boutell

public class FileWrite {
	public static void main(String[] args) {
	    try {
	      FileWriter myWriter = new FileWriter("fileyeet.txt");
	      myWriter.write("yeet yeet yeet yeet yuh yeet 5/11/2021");
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	//Makes a file writer called myWriter inside the file named “fileyeet.txt”. 
	//then writes in the file “yeet yeet yeet… “. Then closes the writer. 
	//Prints whether the entry was successfully written to that file or 
	//if it was not and there was some sort of error. 
	
	public static void writeFile(ArrayList<String> data, String fileName) {
		try {
			ArrayList<String> oldData = Filereader.readFile(fileName);
			SavingFiles.saveFile(fileName);
			
			

			FileWriter myWriter =new FileWriter(fileName);
			
			for (String dataLine : oldData) {
				myWriter.write(dataLine + "\n");
			}
			
			for (String dataLine : data) {
				myWriter.write(dataLine + "\n");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			//prints if the data was written to the file successfully or not
		}
	  }

	public static void clearFile(String fileName) {
		File myObj = new File(fileName);
		//gets the file, calls it myObj
		myObj.delete();
		//deletes everything inside the file
	}

}
