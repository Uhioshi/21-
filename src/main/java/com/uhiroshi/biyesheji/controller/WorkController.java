package com.uhiroshi.biyesheji.controller;

import com.uhiroshi.biyesheji.common.DateUtil;
import com.uhiroshi.biyesheji.common.Result;
import com.uhiroshi.biyesheji.mapper.workMapper;
import com.uhiroshi.biyesheji.pojo.dto.AvgVO;
import com.uhiroshi.biyesheji.pojo.dto.NewWorkDTO;
import com.uhiroshi.biyesheji.pojo.dto.StuWorkDTO;
import com.uhiroshi.biyesheji.pojo.dto.StuWorkDetalDTO;
import com.uhiroshi.biyesheji.pojo.po.homework;
import com.uhiroshi.biyesheji.pojo.po.stuhomework;
import com.uhiroshi.biyesheji.pojo.vo.NOgVO;
import com.uhiroshi.biyesheji.pojo.vo.editWorkVO;
import com.uhiroshi.biyesheji.pojo.vo.ogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Slf4j
@RestController
public class WorkController {
    @Autowired
    private workMapper workMapper;

    @GetMapping("getWork")
    public Result getWork(Long ID){
        try{
            if(ID==null)
                return Result.buildResult(Result.Status.ERROR);
            return Result.buildResult(Result.Status.OK,workMapper.getWork(ID));
        }catch(Exception e){
            log.info("获取作业列表出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("getStuwork")
    public Result getStuWork(Long homeworkID){
        try{
            if(homeworkID==null)
                return Result.buildResult(Result.Status.ERROR);
            //所有作业信息
            List<StuWorkDetalDTO> list=workMapper.getStuwork(homeworkID);

            //设置标记位，超过七天 设置为1
            for (StuWorkDetalDTO sd:
                 list) {
                Date enddate=DateUtil.getDateByFullDateStr(sd.getEnd_time().toString().replace(".0",""));

                System.out.println(DateUtil.daysBetween(enddate,new Date()));
                if (DateUtil.daysBetween(enddate,new Date())<=7)
                        sd.setIspass(1);
                else
                    sd.setIspass(0);
            }

            return Result.buildResult(Result.Status.OK,list);
        }catch(Exception e){
            log.info("获取作业ID为"+homeworkID+"的学生作业出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("getStuworkByID")
    public Result getStuworkByID(Long ID){
        try{
            if(ID==null)
                return Result.buildResult(Result.Status.ERROR);
            return Result.buildResult(Result.Status.OK,workMapper.getStuworkByID(ID));
        }catch(Exception e){
            log.info("获取作业ID为"+ID+"的学生作业出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/uploadStuWorkInfo")
    public Result  uploadStuWorkInfo(@RequestBody StuWorkDTO workDTO){
        try{

            if(workDTO==null)
                return Result.buildResult(Result.Status.ERROR);

            workMapper.postInfo(workDTO);
            List<AvgVO> avgList=workMapper.avgList();

            Long stuID=workMapper.getStuIDFromSW(workDTO.getStuworkID());


            AvgVO tmp=new AvgVO();
            for (AvgVO ag:
                 avgList) {

                if (ag.getStudentID().toString().equals(stuID.toString())){

                    tmp.setStudentID(stuID);
                    tmp.setWorkscore(ag.getWorkscore());
                }

            }

            System.out.println("最终平均分："+tmp.getWorkscore());
            workMapper.upstuscore(tmp);

            return Result.buildResult(Result.Status.OK);
        }catch(Exception e){
            log.info("上传作业ID为"+workDTO.getStuworkID()+"的学生作业出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addNewWork")
    public Result addNewWork(@RequestBody NewWorkDTO workDTO){
        try{

            if(workDTO==null)
                return Result.buildResult(Result.Status.ERROR);

             return Result.buildResult(Result.Status.OK,workMapper.addNewWork(workDTO));
        }catch(Exception e){
            log.info("新增"+workDTO.getTeacherName()+"的老师的作业出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/getWorkByObject")
    public Result getWorkByObject(@RequestBody NOgVO og){
        try{
            System.out.println(og.getStudentID());
            if(og==null)
                return Result.buildResult(Result.Status.ERROR);
            List<homework> homeworkList=workMapper.getWorkByObject(og);
            List<editWorkVO> editWorkVOList=new ArrayList<>();
            for (homework h:
                 homeworkList) {
                editWorkVO obj=new editWorkVO();
                BeanUtils.copyProperties(h,obj);

                Date begindate=DateUtil.getDateByFullDateStr(h.getStart_time().toString().replace(".0",""));
                Date enddate=DateUtil.getDateByFullDateStr(h.getEnd_time().toString().replace(".0",""));
                obj.setBegin_time(begindate);
                obj.setEnded_time(enddate);
                Date ndate=new Date();





                if(isEffectiveDate(ndate,obj.getBegin_time(),obj.getEnded_time())

                )
                    obj.setIspass(1);
                else
                    obj.setIspass(0);


                editWorkVOList.add(obj);
            }


            List<stuhomework> woLists=workMapper.getBeenModiWork(og.getStudentID());

            int i=0;
            List<Integer> k=new ArrayList<>();
            for (editWorkVO e:
                 editWorkVOList) {
                    i=i+1;
                    for (stuhomework sh:
                        woLists
                    ){

                       if(e.getHomeworkID()==sh.getHomeworkID()){
                         k.add(i);
                       }

                    }
            }




            return Result.buildResult(Result.Status.OK,editWorkVOList);
        }catch(Exception e){
            log.info("学生获取"+og.getGrade()+"年级"+og.getObject()+"作业信息出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getWorkinfo")
    public Result getWorkinfo(Long ID){
        try{

            if(ID==null)
                return Result.buildResult(Result.Status.ERROR);



            return Result.buildResult(Result.Status.OK,workMapper.getWorkinfo(ID));
        }catch(Exception e){
            log.info("获取作业ID为"+ID+"的作业信息出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/postStuWork")
    public Result postStuWork(@RequestBody stuhomework sh){
        try{
            if(sh==null)
                return Result.buildResult(Result.Status.ERROR);
            sh.setCreate_time(new Timestamp(System.currentTimeMillis()));
            return Result.buildResult(Result.Status.OK,workMapper.postStuWork(sh));
        }catch(Exception e){
            log.info("上传作业ID为"+sh.getHomeworkID()+"的作业信息出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }



    //判断是否在一区间
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

}
