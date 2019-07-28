import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InputParser {

    private RandomNumbers randomNumbers = new RandomNumbers();

    public static void main(String[] args)throws Exception
    {
        InputParser inputParser = new InputParser();
        inputParser.readFile(args[0]);
    }

    //read a file
    public void readFile (String pathFile) throws IOException {
        File file = new File(pathFile);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            randomNumbers.add(st);

    }

    public RandomNumbers getRandomNumbers() {
        return randomNumbers;
    }
}
