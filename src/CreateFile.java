import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile{

    private String input;

    CreateFile() {
        input = "NewFile";
    }

    String getinput(String input){
        return input;
    }

    void setinput(String input){this.input = input;}

    void create() {
       try {
        File myObj;
        myObj = new File("/Users/CesarSalcido/Desktop/JavaPrograms/" + input + ".txt");
        System.out.println("Successfully wrote to the file.");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }
}
