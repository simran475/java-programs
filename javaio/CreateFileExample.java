import java.io.File;  // Importing the File class
import java.io.IOException;  // Importing the IOException class for handling errors
public class CreateFileExample{
    public static void main(String[] args){
        try{
            File obj = new File("newFile.txt");
            if(obj.createNewFile()){ // if it returns true, i.e., successfully created
                System.out.println("The file is created successfully: " + obj.getName());
            }
            else{ // if it returns false, i.e., file already exists
                System.out.println("File already exists");
            }
        }
        catch (IOException e){ // to catch exceptions if any error occurs
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}