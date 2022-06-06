package com.uhiroshi.biyesheji.pojo.vo;

import java.util.List;

public class KnowConQuesVO {

    private long ID;
    private String knowledgePoint;
    private Integer teacherID;
    private QKnowledgeVO qKnow;



    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getKnowledgePoint() {
        return knowledgePoint;
    }

    public void setKnowledgePoint(String knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public QKnowledgeVO getqKnow() {
        return qKnow;
    }

    public void setqKnow(QKnowledgeVO qKnow) {
        this.qKnow = qKnow;
    }
}
