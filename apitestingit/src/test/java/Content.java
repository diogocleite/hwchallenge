import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("content")
    private String content;

    public Content(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
