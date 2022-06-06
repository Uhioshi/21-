package com.uhiroshi.biyesheji.mapper;

import com.uhiroshi.biyesheji.pojo.po.answer;

import java.util.List;

public interface answerMapper {
    List<answer> getByID(Long ID);
}
