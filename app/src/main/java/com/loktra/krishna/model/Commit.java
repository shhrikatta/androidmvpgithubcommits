
package com.loktra.krishna.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Commit {

    @SerializedName("author")
    private com.loktra.krishna.model.Author Author;
    @SerializedName("comment_count")
    private Long CommentCount;
    @SerializedName("comments_url")
    private String CommentsUrl;
    @SerializedName("commit")
    private Commit Commit;
    @SerializedName("committer")
    private com.loktra.krishna.model.Committer Committer;
    @SerializedName("html_url")
    private String HtmlUrl;
    @SerializedName("message")
    private String Message;
    @SerializedName("parents")
    private List<Parent> Parents;
    @SerializedName("sha")
    private String Sha;
    @SerializedName("tree")
    private com.loktra.krishna.model.Tree Tree;
    @SerializedName("url")
    private String Url;
    @SerializedName("verification")
    private com.loktra.krishna.model.Verification Verification;

    public com.loktra.krishna.model.Author getAuthor() {
        return Author;
    }

    public void setAuthor(com.loktra.krishna.model.Author author) {
        Author = author;
    }

    public Long getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(Long commentCount) {
        CommentCount = commentCount;
    }

    public String getCommentsUrl() {
        return CommentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        CommentsUrl = commentsUrl;
    }

    public Commit getCommit() {
        return Commit;
    }

    public void setCommit(Commit commit) {
        Commit = commit;
    }

    public com.loktra.krishna.model.Committer getCommitter() {
        return Committer;
    }

    public void setCommitter(com.loktra.krishna.model.Committer committer) {
        Committer = committer;
    }

    public String getHtmlUrl() {
        return HtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        HtmlUrl = htmlUrl;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public List<Parent> getParents() {
        return Parents;
    }

    public void setParents(List<Parent> parents) {
        Parents = parents;
    }

    public String getSha() {
        return Sha;
    }

    public void setSha(String sha) {
        Sha = sha;
    }

    public com.loktra.krishna.model.Tree getTree() {
        return Tree;
    }

    public void setTree(com.loktra.krishna.model.Tree tree) {
        Tree = tree;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public com.loktra.krishna.model.Verification getVerification() {
        return Verification;
    }

    public void setVerification(com.loktra.krishna.model.Verification verification) {
        Verification = verification;
    }

}