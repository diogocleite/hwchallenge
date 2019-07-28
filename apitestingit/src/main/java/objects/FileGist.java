package objects;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class FileGist {

    @SerializedName("description")
    private String description;

    @SerializedName("public")
    private boolean publicc;

    @SerializedName("files")
    private Map<String, Content> files;

    public FileGist(String description, boolean publicc, Map<String, Content> files){
        this.description = description;
        this.publicc = publicc;
        this.files = files;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublicc() {
        return publicc;
    }

    public void setPublicc(boolean publicc) {
        this.publicc = publicc;
    }

    public Map<String, Content> getFiles() {
        return files;
    }

    public void setFiles(Map<String, Content> files) {
        this.files = files;
    }
}
