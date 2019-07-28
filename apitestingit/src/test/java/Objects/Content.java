package Objects;

import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("filename")
    private String filename;

    @SerializedName("type")
    private String type;

    @SerializedName("language")
    private String language;

    @SerializedName("raw_url")
    private String raw_url;

    @SerializedName("size")
    private String size;

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRaw_url() {
        return raw_url;
    }

    public void setRaw_url(String raw_url) {
        this.raw_url = raw_url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
