package com.uhiroshi.biyesheji.pojo.po;

import java.sql.Timestamp;

public class homework {
    private long homeworkID;
    private String title;
    private byte[] image;
    private long teacherID;
    private String teacherName;
    private Timestamp start_time;
    private String object;
    private Timestamp end_time;

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

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }
}
