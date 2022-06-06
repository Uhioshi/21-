package com.uhiroshi.biyesheji.service;

import com.uhiroshi.biyesheji.pojo.po.konwledgepoint;
import com.uhiroshi.biyesheji.pojo.po.question;
import com.uhiroshi.biyesheji.pojo.vo.classInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.contextLists;
import com.uhiroshi.biyesheji.pojo.vo.postquesVO;
import java.util.List;

public interface questionService {
    List<contextLists> getquestionList(Integer grade);

    question querybyid(long ID);

    int postStuquestion(postquesVO po);

    int postTeaquestion(postquesVO po);

    List<konwledgepoint> getByPointStu(classInfoVO cl);
}
