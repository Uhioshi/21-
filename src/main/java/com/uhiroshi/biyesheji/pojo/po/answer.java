package com.uhiroshi.biyesheji.pojo.po;

public class answer {
    private long answerID;
    private long studentID;
    private String studentName;
    private Long teacherID;
    private String teacherName;
    private String answercontext;
    private byte[] image;
    private long questionID;

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(long answerID) {
        this.answerID = answerID;
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


    public String getAnswercontext() {
        return answercontext;
    }

    public void setAnswercontext(String answercontext) {
        this.answercontext = answercontext;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }
}
