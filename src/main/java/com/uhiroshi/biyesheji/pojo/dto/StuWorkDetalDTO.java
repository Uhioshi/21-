package com.uhiroshi.biyesheji.pojo.dto;

import java.sql.Timestamp;

public class StuWorkDetalDTO {
    private Long stuworkID;
    private Long studentID;
    private Long homeworkID;
    private String studentName;
    private String home_context;
    private String home_title;
    private Timestamp create_time;
    private Timestamp update_time;
    private Float workscore;
    private String suggest;
    private Integer ispass;
    private Timestamp end_time;

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public Long getStuworkID() {
        return stuworkID;
    }

    public void setStuworkID(Long stuworkID) {
        this.stuworkID = stuworkID;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(Long homeworkID) {
        this.homeworkID = homeworkID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getHome_context() {
        return home_context;
    }

    public void setHome_context(String home_context) {
        this.home_context = home_context;
    }

    public String getHome_title() {
        return home_title;
    }

    public void setHome_title(String home_title) {
        this.home_title = home_title;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Float getWorkscore() {
        return workscore;
    }

    public void setWorkscore(Float workscore) {
        this.workscore = workscore;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Integer getIspass() {
        return ispass;
    }

    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }
}
