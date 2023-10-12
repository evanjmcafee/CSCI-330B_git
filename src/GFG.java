import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Main class
public class GFG {

    // Method 1
    // To read the file content into string with
    // Files.readAllBytes(Path path)
    private static String method(String file_path)
    {

        // Declaring an empty string
        String str = "";

        // Try block to check for exceptions
        try {

            // Reading all bytes form file and
            // storing that in the string
            str = new String(
                    Files.readAllBytes(Paths.get(file_path)));
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Print the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        return str;
    }

    // Method 2
    // Main driver method
    public static void main(String[] args)
    {

        // Path is passed from local directory of machine
        // and stored in a string
        String filePath = "C:\\Users\\HP\\Desktop\\gfg.txt";

        // Now call Method1 to
        // read the content in above directory
        System.out.println(method(filePath));
    }
}