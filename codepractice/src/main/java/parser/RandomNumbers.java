package parser;

import java.util.ArrayList;

public class RandomNumbers {

    private ArrayList<Line> lines;

    RandomNumbers()
    {
        lines = new ArrayList<Line>();
    }

    //split string by tab to create a new line
    public void add(String res)
    {
        String id = null;
        String value = null;
        String[] resA = res.split("\t");
        if(resA.length == 2)
        {
            id = resA[0];
            value = resA[1];
        }

        Line newLine = new Line(id,value,res);

        lines.add(newLine);
    }

    //return the number of lines
    public Integer length()
    {
        return lines.size();
    }

    //return the lines
    public ArrayList<Line> getLines() {
        return lines;
    }

}
