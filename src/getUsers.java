import java.io.File;

public class getUsers {


    String YOURNAME;

    static String PASSWORD = "fuck you";
    static void RecursivePrint(File[] arr, int index, int level)
    {
        // terminate condition
        if (index == arr.length)
            return;

        // tabs for internal levels
        for (int i = 0; i < level; i++)
            System.out.print("\t");

            // for sub-directories
        if (arr[index].isDirectory()) {
            String YOURNAME=arr[index].getName();
            System.out.println(arr[index].getName());

        }

        // recursion for main directory
        RecursivePrint(arr, ++index, level);
    }
    // Driver Method

    public static File[] get(String you) {
        // Provide full path for directory(change
        // accordingly)
        String maindirpath
                = "C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\users";

        // File object
        File maindir = new File(maindirpath);

        if (maindir.exists() && maindir.isDirectory()) {

            // array for files and sub-directories
            // of directory pointed by maindir
            File arr[] = maindir.listFiles();

            System.out.println(
                    "**********************************************");
            System.out.println(
                    "Files from main directory : " + maindir);
            System.out.println(
                    "**********************************************");

            // Calling recursive method
            RecursivePrint(arr, 0, 0);

        }
        return new File[0];
    }


}