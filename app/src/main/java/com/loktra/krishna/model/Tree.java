
package com.loktra.krishna.model;

import com.google.gson.annotations.SerializedName;

public class Tree {

    @SerializedName("sha")
    private String Sha;
    @SerializedName("url")
    private String Url;

    public String getSha() {
        return Sha;
    }

    public void setSha(String sha) {
        Sha = sha;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

}
