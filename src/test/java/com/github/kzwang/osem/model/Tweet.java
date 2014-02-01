package com.github.kzwang.osem.model;

import com.github.kzwang.osem.annotations.*;
import com.github.kzwang.osem.serializer.ImageSerializer;

import java.util.Date;
import java.util.List;

@Indexable(name = "tweetIndex", numericDetection = NumericDetectionEnum.TRUE, allFieldEnabled = false,
        sizeFieldEnabled = true, timestampFieldEnabled = true, timestampFieldPath = "tweetDatetime",
        timestampFieldFormat = "yyyy/MM/dd HH:mm:ss")
public class Tweet {

    @IndexableId(index = IndexEnum.NOT_ANALYZED)
    @IndexableProperty
    private Long id;

    @IndexableComponent
    private User user;

    @IndexableProperty(store = true)
    private String tweetString;

    @IndexableProperty(format = "yyyy/MM/dd")
    private Date tweetDate;

    @IndexableProperty(serializer = ImageSerializer.class, jsonInclude = JsonInclude.ALWAYS)
    private String image;

    @IndexableProperty(analyzer = "standard")
    private List<String> urls;

    @IndexableComponent(name = "mentionedUsers")
    private List<User> mentionedUserList;

    @IndexableProperty
    private Boolean flagged;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTweetString() {
        return tweetString;
    }

    public void setTweetString(String tweetString) {
        this.tweetString = tweetString;
    }

    public Date getTweetDate() {
        return tweetDate;
    }

    @IndexableProperty(name = "tweetDatetime", format = "yyyy/MM/dd HH:mm:ss")
    public Date getTweetDatetime() {
        return tweetDate;
    }

    public void setTweetDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<User> getMentionedUserList() {
        return mentionedUserList;
    }

    public void setMentionedUserList(List<User> mentionedUserList) {
        this.mentionedUserList = mentionedUserList;
    }

    public Boolean getFlagged() {
        return flagged;
    }

    public void setFlagged(Boolean flagged) {
        this.flagged = flagged;
    }
}
