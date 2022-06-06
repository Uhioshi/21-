package com.uhiroshi.biyesheji.pojo.vo;

import io.swagger.models.auth.In;

public class recommandDTO {
    private Long questionID;
    private String title;
    private Integer readCount;

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
}
