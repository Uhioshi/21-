package com.uhiroshi.biyesheji.pojo.po;

import java.sql.Timestamp;

public class student {
    private long studentID;
    private String studentName;
    private Integer sclass;
    private Integer grade;
    private Integer score;
    private float workscore;
    private Integer isexcellent;
    private String IDCard;
    private Timestamp inter_time;

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public Timestamp getInter_time() {
        return inter_time;
    }

    public void setInter_time(Timestamp inter_time) {
        this.inter_time = inter_time;
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

    public Integer getSclass() {
        return sclass;
    }

    public void setSclass(Integer sclass) {
        this.sclass = sclass;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public float getWorkscore() {
        return workscore;
    }

    public void setWorkscore(float workscore) {
        this.workscore = workscore;
    }

    public Integer getIsexcellent() {
        return isexcellent;
    }

    public void setIsexcellent(Integer isexcellent) {
        this.isexcellent = isexcellent;
    }
}
