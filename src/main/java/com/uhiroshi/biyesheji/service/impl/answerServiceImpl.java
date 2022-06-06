package com.uhiroshi.biyesheji.service.impl;

import com.uhiroshi.biyesheji.mapper.answerMapper;
import com.uhiroshi.biyesheji.pojo.po.answer;
import com.uhiroshi.biyesheji.service.answerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class answerServiceImpl implements answerService {
    @Autowired
    private answerMapper answerMapper;

    @Override
    public List<answer> getanswer(Long ID) {
        try{
            return answerMapper.getByID(ID);
        }catch (Exception e){
            log.error("查询答案出错"+e);
        }
        return null;
    }
}
