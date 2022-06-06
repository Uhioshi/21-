package com.uhiroshi.biyesheji.pojo.vo;

import java.util.List;

public class KnowRealteQuesVO {
    private Long pointID;
    private List<Long> list;


    public KnowRealteQuesVO(Long pointID, List<Long> list) {
        this.pointID = pointID;
        this.list = list;
    }

    public Long getPointID() {
        return pointID;
    }

    public void setPointID(Long pointID) {
        this.pointID = pointID;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
}
