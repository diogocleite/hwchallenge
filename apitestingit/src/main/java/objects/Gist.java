package objects;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Gist {

    @SerializedName("url")
    private String url;

    @SerializedName("forks_url")
    private String forks_url;

    @SerializedName("commits_url")
    private String commits_url;

    @SerializedName("id")
    private String id;

    @SerializedName("node_id")
    private String node_id;

    @SerializedName("git_pull_url")
    private String git_pull_url;

    @SerializedName("git_push_url")
    private String git_push_url;

    @SerializedName("html_url")
    private String html_url;

    @SerializedName("files")
    private Map<String, Content> files;

    @SerializedName("public")
    private String publicc;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("description")
    private String description;

    @SerializedName("comments")
    private String comments;

    @SerializedName("user")
    private String user;

    @SerializedName("comments_url")
    private String comments_url;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("truncated")
    private String truncated;


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

    public Map<String, Content> getFileGist() {
        return files;
    }

    public void setFileGist(Map<String, Content> files) {
        this.files = files;
    }

    public String getForks_url() {
        return forks_url;
    }

    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getGit_pull_url() {
        return git_pull_url;
    }

    public void setGit_pull_url(String git_pull_url) {
        this.git_pull_url = git_pull_url;
    }

    public String getGit_push_url() {
        return git_push_url;
    }

    public void setGit_push_url(String git_push_url) {
        this.git_push_url = git_push_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getPublicc() {
        return publicc;
    }

    public void setPublicc(String publicc) {
        this.publicc = publicc;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getTruncated() {
        return truncated;
    }

    public void setTruncated(String truncated) {
        this.truncated = truncated;
    }
}
