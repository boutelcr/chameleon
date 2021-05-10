import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.IOException;  // Import the IOException class to handle errors

// @Author - Sophie Baer

public class FileWrite {
	public static void main(String[] args) {
	    try {
	      FileWriter myWriter = new FileWriter("fileyeet.txt");
	      myWriter.write("yeet yeet yeet yeet yuh yeet");
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

}
