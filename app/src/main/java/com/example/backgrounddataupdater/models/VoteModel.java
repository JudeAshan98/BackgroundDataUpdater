package com.example.backgrounddataupdater.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.backgrounddataupdater.util.Constants;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = Constants.TABLE_NAME_VOTES)
public class VoteModel {
    @PrimaryKey(autoGenerate = true)
    private long vote_id;

    @SerializedName("Vote")
    private int Vote;

    @SerializedName("fname")
    private String fname;

    @SerializedName("lname")
    private String lname;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("city")
    private String city;

    @SerializedName("province")
    private String province;

    @SerializedName("Comment")
    private String Comment;

    @SerializedName("con_status")
    private String con_status;

    public void setVote_id(long zone_id) {
        this.vote_id = zone_id;
    }

    public void setVote(int vote) {
        Vote = vote;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setCon_status(String con_status) {
        this.con_status = con_status;
    }

    public long getVote_id() {
        return vote_id;
    }

    public int getVote() {
        return Vote;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getComment() {
        return Comment;
    }

    public String getCon_status() {
        return con_status;
    }
}
