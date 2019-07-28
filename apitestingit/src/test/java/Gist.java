import com.google.gson.annotations.SerializedName;

public class Gist {

    @SerializedName("url")
    private String url;

    @SerializedName("id")
    private String id;

    @SerializedName("description")
    private String description;

    @SerializedName("files")
    private FileGist fileGist;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FileGist getFileGist() {
        return fileGist;
    }

    public void setFileGist(FileGist fileGist) {
        this.fileGist = fileGist;
    }

}
