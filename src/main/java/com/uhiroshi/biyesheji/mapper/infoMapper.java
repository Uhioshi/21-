package com.uhiroshi.biyesheji.mapper;

import com.uhiroshi.biyesheji.pojo.po.admin;
import com.uhiroshi.biyesheji.pojo.po.object;
import com.uhiroshi.biyesheji.pojo.po.student;
import com.uhiroshi.biyesheji.pojo.po.teacher;
import io.swagger.models.auth.In;

import java.util.List;

public interface infoMapper {
    List<String> getoblist(Integer grade);

    String login(Long userID);

    student getStuInfo(Long userID);

    Integer getRole(Long userID);

    teacher getTeaInfo(Long userID);

    admin getAdminInfo(Long userID);

    List<student> getStuInfoBygrade(Integer grade);

    int postStuinfo(student stu);

    int addnewStu(student s);

    List<teacher> getTeaInfoBygrade(Integer grade);

    int updateStuExc(Long studentID);

    int addScore(Long studentID);

    int minusScore(Long studentID);

}
