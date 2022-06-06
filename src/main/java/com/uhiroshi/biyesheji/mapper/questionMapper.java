package com.uhiroshi.biyesheji.mapper;

import com.uhiroshi.biyesheji.pojo.dto.PointQuesDTO;
import com.uhiroshi.biyesheji.pojo.po.answer;
import com.uhiroshi.biyesheji.pojo.po.konwledgepoint;
import com.uhiroshi.biyesheji.pojo.po.question;
import com.uhiroshi.biyesheji.pojo.po.sclass;
import com.uhiroshi.biyesheji.pojo.vo.*;
import io.swagger.models.auth.In;

import java.util.List;

public interface questionMapper {
    List<contextLists> queryall(Integer grade);


    question getinfo(long ID);

    List<recommandDTO> getrecommand(ogVO og);


    //获取自己提问的问题
    List<contextLists> getpersonalques(Long studentID);

    List<contextLists> getByObject(String object);

    //获得学生评论
     List<answer> getStuanswer(Long ID);

     //删除学生回答
    int deleteStuanswer(Long ID);

    List<contextLists> getquesByObject(String object,Integer grade);

    List<contextLists> getQuesByKnowledge(Long ID);

    //学生提问问题
    int Stupostquestion(question qu);

    //老师提问问题
    int Teapostquestion(question qu);

    List<konwledgepoint> getKnowlegdePoint(Long userID);

    List<contextLists> getByPoint(Long ID);

    //获取指定知识点 下的所有问题
    List<QKnowledgeVO> QuestionByknowledge (Long pointID);

    //获取所以知识点 及其下的question信息
    List<QKnowledgeVO> getKnowledgeQues();

    Long getTeaID(sclass sc);

    int StucommentQues(StuCommentVO sc);

    int TeacommentQues(StuCommentVO sc);

    List<contextLists> getNonePointQues(String object,Integer grade);

    List<contextLists> getNoneTypeQues(String object,Integer grade);

    List<PointQuesDTO> getAllPointQues(Long teacherID);

    List<Long> getQID(Long pointID);

    int addPrealteQues(List<KnowAddReaVO> list);

    int delPrealteQues(KnowRealteQuesVO kn);

    int addnewknow(konwledgepoint kp);

    Long getKnowID(Long teacherID,String knowledgepoint);

    int StuScorequestion(question qu);

    List<PointQuesDTO> getAllPointUniq(Long teacherID);

    int cancelcommand(Integer iscommand,Long questionID);
}
