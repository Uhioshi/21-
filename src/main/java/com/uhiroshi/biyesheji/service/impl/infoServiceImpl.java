package com.uhiroshi.biyesheji.service.impl;

import com.uhiroshi.biyesheji.mapper.infoMapper;
import com.uhiroshi.biyesheji.pojo.po.admin;
import com.uhiroshi.biyesheji.pojo.po.student;
import com.uhiroshi.biyesheji.pojo.po.teacher;
import com.uhiroshi.biyesheji.pojo.vo.AdminInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.StuInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.TeaherInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.userInfoVO;
import com.uhiroshi.biyesheji.service.infoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class infoServiceImpl implements infoService {
    @Autowired
    private infoMapper infoMapper;
    @Override
    public List<String> getobject(Integer grade) {
        try{
            return infoMapper.getoblist(grade);
        }catch(Exception e){
            log.error("查询当前学生学科出错"+e);
        }
        return null;
    }

    @Override
    public userInfoVO getStuInfo(Long userID) {
        try{
            //获取学生信息
            student stu=infoMapper.getStuInfo(userID);
            userInfoVO stuVO=new userInfoVO();
            //添加角色身份
            BeanUtils.copyProperties(stu,stuVO);
            stuVO.setUserID(stu.getStudentID());
            stuVO.setUserName(stu.getStudentName());
            stuVO.setRoleID(1);
            System.out.println(stuVO.getScore());
            return stuVO;
        }catch(Exception e){
            log.error("获取学生身份出错"+e);
        }
       return null;
    }

    @Override
    public userInfoVO getTeacherInfo(Long userID) {
        try{
            //获取教师信息
            teacher tea=infoMapper.getTeaInfo(userID);
            userInfoVO teaVO=new userInfoVO();
            //添加角色身份
            BeanUtils.copyProperties(tea,teaVO);
            teaVO.setUserID(tea.getTeacherID());
            teaVO.setUserName(tea.getTeacherName());
            teaVO.setRoleID(2);
            return teaVO;
        }catch(Exception e){
            log.error("获取教师身份出错"+e);
        }
        return null;
    }


    @Override
    public userInfoVO getAdminInfo(Long userID) {
        try{
            //获取教师信息
            admin ad=infoMapper.getAdminInfo(userID);
            userInfoVO adVO=new userInfoVO();
            //添加角色身份
//            BeanUtils.copyProperties(ad,adVO);

            adVO.setGrade(ad.getGrade());
            adVO.setUserID(ad.getAdminID());
            adVO.setUserName(ad.getAdminName());
            adVO.setRoleID(3);
            return adVO;
        }catch(Exception e){
            log.error("获取主任身份出错"+e);
        }
        return null;
    }
}
