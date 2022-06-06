package com.uhiroshi.biyesheji.pojo.vo;

public class userInfoVO {
    private long userID;
    private String userName;
    private Integer grade;
    private Integer score;
    private float workscore;
    private Integer isexcellent;
    private Integer roleID;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
