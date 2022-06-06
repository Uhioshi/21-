package com.uhiroshi.biyesheji.pojo.dto;

import java.util.List;

public class CollpaseDTO {
    private String knowledgepoint;
    private List<PointQuesDTO> list;

    public CollpaseDTO(String knowledgepoint) {
        this.knowledgepoint = knowledgepoint;
    }

    public String getKnowledgepoint() {
        return knowledgepoint;
    }

    public void setKnowledgepoint(String knowledgepoint) {
        this.knowledgepoint = knowledgepoint;
    }

    public List<PointQuesDTO> getList() {
        return list;
    }

    public void setList(List<PointQuesDTO> list) {
        this.list = list;
    }
}
