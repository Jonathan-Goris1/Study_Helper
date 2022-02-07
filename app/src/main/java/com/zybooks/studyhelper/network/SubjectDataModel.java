package com.zybooks.studyhelper.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SubjectDataModel {

    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("updatetime")
    @Expose
    private long updatetime;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }

}
