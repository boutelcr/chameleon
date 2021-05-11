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
	public static void writeFile(ArrayList<String> data, String fileName) {
	try {
		SavingFiles.saveFile(fileName);
	 
		FileWriter myWriter = new FileWriter(fileName);
	    for(String dataLine : data) {
	    	myWriter.write(dataLine);
//	    	myWriter.write();
		}
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

}
