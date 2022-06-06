package com.uhiroshi.biyesheji.pojo.vo;

public class StuInfoVO {
    private long studentID;
    private String studentName;
    private Integer sclass;
    private Integer grade;
    private Integer score;
    private float workscore;
    private Integer isexcellent;
    private Integer roleID;


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

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }
}
