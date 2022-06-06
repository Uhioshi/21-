package com.uhiroshi.biyesheji.pojo.vo;

import java.sql.Timestamp;

public class StuCommentVO {
    private Long studentID;
    private String studentName;
    private String answercontext;
    private Timestamp tdate;
    private Long questionID;


    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAnswercontext() {
        return answercontext;
    }

    public void setAnswercontext(String answercontext) {
        this.answercontext = answercontext;
    }

    public Timestamp getTdate() {
        return tdate;
    }

    public void setTdate(Timestamp tdate) {
        this.tdate = tdate;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }
}
