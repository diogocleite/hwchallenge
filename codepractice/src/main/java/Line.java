public class Line {

    private String value;
    private String id;
    private String line;

    Line(String id, String value, String line)
    {
        this.id = id;
        this.value = value;
        this.line = line;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getLine() {
        return line;
    }

}
