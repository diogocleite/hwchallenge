package numbers;

import parser.InputParser;
import parser.Line;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RandomNumbersTest {

    private static InputParser inputParser;
    private static Integer SIZE = 50;
    private static String DEFAULT_VALUE = "src/main/resources/random_numbers.txt";

    @BeforeClass
    public static void loadFile() throws Exception {
        inputParser = new InputParser();
        String inputFilePath = System.getProperty("inputFile", DEFAULT_VALUE);
        inputParser.readFile(inputFilePath);
    }

    @Test
    public void testThatTheFileHasFiftyLines() {
        Assert.assertEquals(SIZE,inputParser.getRandomNumbers().length());
    }

    @Test
    public void testThatAllLinesHaveATabToSeparateLineAndRandomNumber()
    {
        ArrayList<Line> lines = inputParser.getRandomNumbers().getLines();
        Boolean fail = false;
        StringBuffer resultMessage = new StringBuffer();

        for(Line line : lines)
        {
            if(line.getLine() == null || !line.getLine().matches("[0-9]+\t[0-9]+"))
            {
                resultMessage.append("objects.Line ");
                resultMessage.append(line.getId());
                resultMessage.append(": Value ");
                resultMessage.append(line.getValue());
                resultMessage.append(" : Complete objects.Line \"");
                resultMessage.append(line.getLine());
                resultMessage.append("\"");
                fail = true;
            }

        }

        assertFalse(resultMessage.toString(), fail);
    }

    @Test
    public void testThatAllLinesHaveALineNumberAndARandomNumber()
    {
        ArrayList<Line> lines = inputParser.getRandomNumbers().getLines();
        Boolean fail = false;
        StringBuffer resultMessage = new StringBuffer();

        for(Line line : lines)
        {
            if(line.getId() == null || line.getId().isEmpty() || line.getValue() == null || line.getValue().isEmpty())
            {
                resultMessage.append("objects.Line ");
                resultMessage.append(line.getId());
                resultMessage.append(": Value ");
                resultMessage.append(line.getValue());
                resultMessage.append(" : Complete objects.Line \"");
                resultMessage.append(line.getLine());
                resultMessage.append("\"");
                resultMessage.append("\n");
                fail = true;
            }

        }

        assertFalse(resultMessage.toString(), fail);
    }

    @Test
    public void testThatAllNumbersAreOnExpectedInterval() {
        ArrayList<Line> lines = inputParser.getRandomNumbers().getLines();
        Boolean fail = false;
        StringBuffer resultMessage = new StringBuffer();

        for(Line line : lines)
        {
            if(line.getId() == null || line.getValue() == null || Integer.parseInt(line.getValue()) < 100 || Integer.parseInt(line.getValue()) > 500)
            {
                resultMessage.append("objects.Line ");
                resultMessage.append(line.getId());
                resultMessage.append(": Value ");
                resultMessage.append(line.getValue());
                resultMessage.append(" : Complete objects.Line \"");
                resultMessage.append(line.getLine());
                resultMessage.append("\"");
                resultMessage.append("\n");
                fail = true;
            }

        }

        assertFalse(resultMessage.toString(),fail);
    }


}
