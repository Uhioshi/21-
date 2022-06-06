package com.uhiroshi.biyesheji.controller;

import com.uhiroshi.biyesheji.common.Result;
import com.uhiroshi.biyesheji.mapper.infoMapper;
import com.uhiroshi.biyesheji.pojo.po.student;
import com.uhiroshi.biyesheji.pojo.po.teacher;
import com.uhiroshi.biyesheji.service.infoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
@Slf4j
public class InfoController {
    @Autowired
    private infoService iservice;
    @Autowired
    private infoMapper infoMapper;

    /**
     * 返回学生所修的学科
     * @param grade
     * @return
     */
    @GetMapping("/getobject")
    public Result getobject(Integer grade){
        if(grade==null)
            return Result.buildResult(Result.Status.ERROR);
        else{
            List<String> objectByStuGrade=iservice.getobject(grade);
            if (objectByStuGrade!=null)
                return Result.buildResult(Result.Status.OK,objectByStuGrade);
        }
        return null;
    }

    /**
     * 返回 所给年级 学生的基本信息
     * @param grade
     * @return
     */
    @GetMapping("/getStuInfoBygrade")
    public Result getStuInfoBygrade(Integer grade){
        if(grade==null)
            return Result.buildResult(Result.Status.ERROR);
        else{
            List<student> stuInfoList=infoMapper.getStuInfoBygrade(grade);
            if (stuInfoList !=null)
                return Result.buildResult(Result.Status.OK,stuInfoList);
        }
        return null;
    }

    /**
     * 修改学生信息
     * @param stu
     * @return
     */
    @PostMapping("/postStu")
    public Result postStu(@RequestBody student stu){
        try{
            infoMapper.postStuinfo(stu);
            Result.buildResult(Result.Status.OK);
        }catch (Exception e){
            log.error("更改学生信息出错"+e);
        }
        return  Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
    }

    /**
     * 教务主任功能 添加新的学生
     * @param stu
     * @return
     */
    @PostMapping("/addNewStu")
    public Result addnew(@RequestBody student stu){
        try{
            infoMapper.addnewStu(stu);
            Result.buildResult(Result.Status.OK);
        }catch (Exception e){
            log.error("添加学生信息出错"+e);
        }
        return  Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
    }

    /**
     * 获取 当前年级的所有教师信息
     * @param grade
     * @return
     */
    @GetMapping("/getTeaInfoBygrade")
    public Result getTeaInfoBygrade(Integer grade){
        if(grade==null)
            return Result.buildResult(Result.Status.ERROR);
        else{
            List<teacher> oblists=infoMapper.getTeaInfoBygrade(grade);
            if (oblists!=null)
                return Result.buildResult(Result.Status.OK,oblists);
        }
        return null;
    }


    @GetMapping("/updateStuExc")
    public Result updateStuExc(Long studentID){
        if(studentID==null)
            return Result.buildResult(Result.Status.ERROR);
        else{
            infoMapper.updateStuExc(studentID);
            return Result.buildResult(Result.Status.OK);
        }

    }






}
