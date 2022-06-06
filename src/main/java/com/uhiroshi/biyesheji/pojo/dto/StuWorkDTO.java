package com.uhiroshi.biyesheji.pojo.dto;

public class StuWorkDTO {

    private Long stuworkID;
    private String suggest;
    private Float workscore;
    private Long studentID;

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getStuworkID() {
        return stuworkID;
    }

    public void setStuworkID(Long stuworkID) {
        this.stuworkID = stuworkID;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Float getWorkscore() {
        return workscore;
    }

    public void setWorkscore(Float workscore) {
        this.workscore = workscore;
    }
}
