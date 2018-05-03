
package com.loktra.krishna.model;

import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("avatar_url")
    private String AvatarUrl;
    @SerializedName("date")
    private String Date;
    @SerializedName("email")
    private String Email;
    @SerializedName("events_url")
    private String EventsUrl;
    @SerializedName("followers_url")
    private String FollowersUrl;
    @SerializedName("following_url")
    private String FollowingUrl;
    @SerializedName("gists_url")
    private String GistsUrl;
    @SerializedName("gravatar_id")
    private String GravatarId;
    @SerializedName("html_url")
    private String HtmlUrl;
    @SerializedName("id")
    private Long Id;
    @SerializedName("login")
    private String Login;
    @SerializedName("name")
    private String Name;
    @SerializedName("organizations_url")
    private String OrganizationsUrl;
    @SerializedName("received_events_url")
    private String ReceivedEventsUrl;
    @SerializedName("repos_url")
    private String ReposUrl;
    @SerializedName("site_admin")
    private Boolean SiteAdmin;
    @SerializedName("starred_url")
    private String StarredUrl;
    @SerializedName("subscriptions_url")
    private String SubscriptionsUrl;
    @SerializedName("type")
    private String Type;
    @SerializedName("url")
    private String Url;

    public String getAvatarUrl() {
        return AvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        AvatarUrl = avatarUrl;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEventsUrl() {
        return EventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        EventsUrl = eventsUrl;
    }

    public String getFollowersUrl() {
        return FollowersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        FollowersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return FollowingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        FollowingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return GistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        GistsUrl = gistsUrl;
    }

    public String getGravatarId() {
        return GravatarId;
    }

    public void setGravatarId(String gravatarId) {
        GravatarId = gravatarId;
    }

    public String getHtmlUrl() {
        return HtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        HtmlUrl = htmlUrl;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOrganizationsUrl() {
        return OrganizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        OrganizationsUrl = organizationsUrl;
    }

    public String getReceivedEventsUrl() {
        return ReceivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        ReceivedEventsUrl = receivedEventsUrl;
    }

    public String getReposUrl() {
        return ReposUrl;
    }

    public void setReposUrl(String reposUrl) {
        ReposUrl = reposUrl;
    }

    public Boolean getSiteAdmin() {
        return SiteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        SiteAdmin = siteAdmin;
    }

    public String getStarredUrl() {
        return StarredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        StarredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return SubscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        SubscriptionsUrl = subscriptionsUrl;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

}
