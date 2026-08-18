import java.io.*;
public class GFG{
    
    public static void main(String[] args)
        throws IOException{
            
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        System.out.print("Enter text to save in file: ");
        String text = reader.readLine();
        BufferedWriter writer = new BufferedWriter(
            new FileWriter("userInput.txt"));
        writer.write(text);
        writer.close();
        System.out.println(
            "Text written successfully to userInput.txt");
    }
}