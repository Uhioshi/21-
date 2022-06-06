package com.uhiroshi.biyesheji.pojo.po;

import java.sql.Timestamp;

public class question {
    private long questionID;
    private String title;
    private String context;
    private byte[] image;
    private long studentID;
    private String studentName;
    private long teacherID;
    private String teacherName;
    private Timestamp tdate;
    private Integer readCouont;
    private Integer grade;
    private Integer sclass;
    private String object;
    private Integer beenPoint;
    private Integer beenType;
    private Integer iscommand;

    public Integer getIscommand() {
        return iscommand;
    }

    public void setIscommand(Integer iscommand) {
        this.iscommand = iscommand;
    }

    public Integer getBeenPoint() {
        return beenPoint;
    }

    public void setBeenPoint(Integer beenPoint) {
        this.beenPoint = beenPoint;
    }

    public Integer getBeenType() {
        return beenType;
    }

    public void setBeenType(Integer beenType) {
        this.beenType = beenType;
    }

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Timestamp getTdate() {
        return tdate;
    }

    public void setTdate(Timestamp tdate) {
        this.tdate = tdate;
    }

    public Integer getReadCouont() {
        return readCouont;
    }

    public void setReadCouont(Integer readCouont) {
        this.readCouont = readCouont;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getSclass() {
        return sclass;
    }

    public void setSclass(Integer sclass) {
        this.sclass = sclass;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
