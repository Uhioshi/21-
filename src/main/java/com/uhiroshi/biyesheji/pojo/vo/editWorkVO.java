package com.uhiroshi.biyesheji.pojo.vo;

import java.sql.Timestamp;
import java.util.Date;

public class editWorkVO {
    private long homeworkID;
    private String title;
    private byte[] image;
    private long teacherID;
    private String teacherName;

    private Date begin_time;
    private String object;
    private Date ended_time;
    private Integer ispass;

    public long getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(long homeworkID) {
        this.homeworkID = homeworkID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(long teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }



    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }


    public Integer getIspass() {
        return ispass;
    }

    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnded_time() {
        return ended_time;
    }

    public void setEnded_time(Date ended_time) {
        this.ended_time = ended_time;
    }
}
