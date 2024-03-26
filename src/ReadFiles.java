import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFiles{

    private String inputRead;

    ReadFiles() {
        inputRead = "";
    }

    String getinput(String inputRead){return inputRead ;}

    void setinput(String inputRead){this.inputRead = inputRead;}


    String readFile(String inputRead)
    {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get("/Users/CesarSalcido/Desktop/JavaPrograms/"+ inputRead +".txt") ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }

}