package com.uhiroshi.biyesheji.pojo.vo;

public class KnowAddReaVO {
    private Long pointID;
    private Long questionID;

    public KnowAddReaVO(Long pointID, Long questionID) {
        this.pointID = pointID;
        this.questionID = questionID;
    }

    public Long getPointID() {
        return pointID;
    }

    public void setPointID(Long pointID) {
        this.pointID = pointID;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }
}
