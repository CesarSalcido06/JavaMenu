import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteFile{
    private String inputTwo;
    private String filename;

    WriteFile(){
        inputTwo="Wrote nothing";
        filename="NewFile";
    }

    String getinputtwo(String inputTwo){
        return inputTwo;
    }

    void setinputtwo(String inputTwo){
        this.inputTwo = inputTwo;
    }

    String getFilename(String filename){
        return filename;
    }

    void setFilename(String filename){this.filename = filename;}

    void write() {
        try {
            FileWriter myWriter = new FileWriter("C:\User\" + filename + ".txt"); //specify path
            myWriter.write(inputTwo);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
