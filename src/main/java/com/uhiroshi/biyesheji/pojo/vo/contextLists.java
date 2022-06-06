package com.uhiroshi.biyesheji.pojo.vo;

import java.sql.Timestamp;
import java.util.Date;

public class contextLists {
    private long questionID;
    private String title;
    private String context;
    private String studentName;
    private Timestamp tdate;
    private int readCount;
    private int iscommand;

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Timestamp getTdate() {
        return tdate;
    }

    public void setTdate(Timestamp tdate) {
        this.tdate = tdate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getIscommand() {
        return iscommand;
    }

    public void setIscommand(int iscommand) {
        this.iscommand = iscommand;
    }
}
