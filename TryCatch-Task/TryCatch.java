import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;//read the file
import java.io.FileWriter;//write into the file 
import java.io.IOException;//handel the input/output errors 

public class TryCatch {
    public static void main(String[] args) {

        String sourceFile = "source.txt";//original file 
        String destinationFile = "destination.txt";//the file where the content will be copied

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));//reade the file 
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {//write into the file

            String line; //variable to hold each line read from the source file

            while ((line = reader.readLine()) != null) {//read each line from the source file until the file ends (null-->empty)
                writer.write(line);//
                writer.newLine();
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);//print the message if the file copied 

        } catch (FileNotFoundException e) {//catch the exception if the source file is not found
            System.err.println("Source file not found. Please check the file path.");

        } catch (IOException e) {//catch the exception if there is an input/output error while copying the file
            System.err.println("An I/O error occurred while copying the file.");
        }
    }
}
