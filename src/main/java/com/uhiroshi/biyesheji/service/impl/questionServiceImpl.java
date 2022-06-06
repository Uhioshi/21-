package com.uhiroshi.biyesheji.service.impl;

import com.uhiroshi.biyesheji.mapper.infoMapper;
import com.uhiroshi.biyesheji.mapper.questionMapper;
import com.uhiroshi.biyesheji.pojo.po.konwledgepoint;
import com.uhiroshi.biyesheji.pojo.po.question;
import com.uhiroshi.biyesheji.pojo.po.sclass;
import com.uhiroshi.biyesheji.pojo.vo.classInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.contextLists;
import com.uhiroshi.biyesheji.pojo.vo.postquesVO;
import com.uhiroshi.biyesheji.service.questionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
public class questionServiceImpl implements questionService {

    @Autowired
    private questionMapper questionMapper;
    @Autowired
    private infoMapper infoMapper;

    @Override
    public List<contextLists> getquestionList(Integer grade) {
        return questionMapper.queryall(grade);
    }

    @Override
    public question querybyid(long ID) {
        return questionMapper.getinfo(ID);
    }


    @Transactional(isolation = Isolation.READ_UNCOMMITTED,propagation = Propagation.MANDATORY)
    @Override
    public int postStuquestion(postquesVO po) {

        try{
            question qu=new question();
            BeanUtils.copyProperties(po,qu);
            int sclass=Integer.parseInt(po.getStudentID().toString().substring(4).substring(0,2));
            qu.setSclass(sclass);
            qu.setTdate(new Timestamp(System.currentTimeMillis()));
            if(po.getUse()==false)
                 questionMapper.Stupostquestion(qu);
            else
            {
                questionMapper.StuScorequestion(qu);
                infoMapper.minusScore(qu.getStudentID());
            }

            return 1;
        }catch(Exception e){
            log.error("上传问题出错"+e);
            return 0;
        }

    }

    @Override
    public int postTeaquestion(postquesVO po) {
        try{
            question qu=new question();
            BeanUtils.copyProperties(po,qu);

            qu.setTdate(new Timestamp(System.currentTimeMillis()));
            questionMapper.Teapostquestion(qu);
            return 1;
        }catch(Exception e){
            log.error("上传问题出错"+e);
            return 0;
        }
    }


    @Override
    public List<konwledgepoint> getByPointStu(classInfoVO cl) {

        try{

            int scla=Integer.parseInt(cl.getStudentID().toString().substring(4).substring(0,2));

            sclass sc=new sclass();
            sc.setGrade(cl.getGrade());
            sc.setObject(cl.getObject());
            sc.setSclass(scla);
            System.out.println(sc.getGrade());
            System.out.println(sc.getObject());
            System.out.println(sc.getSclass());
            Long teaID=questionMapper.getTeaID(sc);

            List<konwledgepoint> konList=questionMapper.getKnowlegdePoint(teaID);
            return konList;

        }catch (Exception e){
            log.error("学生"+cl.getStudentID()+"获取知识点出错"+e);
        }

        return null;
    }
}
