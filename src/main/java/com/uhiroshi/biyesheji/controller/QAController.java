package com.uhiroshi.biyesheji.controller;

import com.uhiroshi.biyesheji.common.Result;
import com.uhiroshi.biyesheji.mapper.infoMapper;
import com.uhiroshi.biyesheji.mapper.questionMapper;
import com.uhiroshi.biyesheji.pojo.dto.CollpaseDTO;
import com.uhiroshi.biyesheji.pojo.dto.PointQuesDTO;
import com.uhiroshi.biyesheji.pojo.po.konwledgepoint;
import com.uhiroshi.biyesheji.pojo.po.question;
import com.uhiroshi.biyesheji.pojo.vo.*;
import com.uhiroshi.biyesheji.service.answerService;
import com.uhiroshi.biyesheji.service.questionService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
public class QAController {
    @Autowired
    private questionService qService;
    @Autowired
    private answerService aService;
    @Autowired
    private questionMapper questionMapper;
    @Autowired
    private infoMapper infoMapper;

    @GetMapping("/getQuesBygrade")
    public Result form(Integer grade){
        return  Result.buildResult(Result.Status.OK,qService.getquestionList(grade));
    }

    //
    @PostMapping("/byid")
    public Result getinfo(long ID){
        return Result.buildResult(Result.Status.OK,qService.querybyid(ID));
    }

    @GetMapping("/getanswer")
    public Result getanswer(Long ID){
        if(ID!=null)
             return Result.buildResult(Result.Status.OK,aService.getanswer(ID));
        else
            return  Result.buildResult(Result.Status.ERROR);
    }

    //获取当前年级的推荐问题
    @PostMapping("/getrecommand")
    public Result getrecommand(@RequestBody  ogVO og){
        if(og==null)
            return Result.buildResult(Result.Status.ERROR);
        else
           return Result.buildResult(Result.Status.OK,questionMapper.getrecommand(og)) ;

    }

    //得到学生自己提问的问题
    @GetMapping("/getpersonalques")
    public Result getpersonalques(Long ID){

        if(ID==null)
            return Result.buildResult(Result.Status.ERROR);
        else{
            return Result.buildResult(Result.Status.OK,questionMapper.getpersonalques(ID));
        }



    }


    //获取学生自己的评论
    @RequestMapping("getStuanswer")
    public Result getStuanswer(Long ID){
        if(ID!=null)
            return Result.buildResult(Result.Status.OK,questionMapper.getStuanswer(ID));
        else
            return Result.buildResult(Result.Status.ERROR);

    }

    @RequestMapping("delStuanswer")
    public Result deleteStuanswer(Long ID){
        if(ID!=null)
            return Result.buildResult(Result.Status.OK,questionMapper.deleteStuanswer(ID));
        else
            return Result.buildResult(Result.Status.ERROR);
    }




    @PostMapping("/getquesByObject")
    public Result getquesByObject(@RequestBody ogVO og){

        if(og==null)
            return Result.buildResult(Result.Status.ERROR);
        else if(og.getObject()==null || og.getGrade()==null)
            return Result.buildResult(Result.Status.ERROR,"请保证参数完整");

        return  Result.buildResult(Result.Status.OK,questionMapper.getquesByObject(og.getObject(),og.getGrade()));
    }

    @GetMapping("getQuesByKnowledge")
    public Result getQuesByKnowledge(Long ID){

        if (ID==null)
            return Result.buildResult(Result.Status.ERROR);

        return Result.buildResult(Result.Status.OK,questionMapper.getQuesByKnowledge(ID));
    }


    @PostMapping("cancelCommand")
    public Result calcelCommand(@RequestBody question qu){

        if (qu==null || qu.getQuestionID()==0 )
            return Result.buildResult(Result.Status.ERROR);

        if (qu.getIscommand()==0)
            qu.setIscommand(1);
        else
            qu.setIscommand(0);
        questionMapper.cancelcommand(qu.getIscommand(),qu.getQuestionID());
        return Result.buildResult(Result.Status.OK);
    }

    @PostMapping("/Stupostquestion")
    public Result Stupostquestion(@RequestBody postquesVO p){

        if(p==null)
            return Result.buildResult(Result.Status.ERROR);
       if( qService.postStuquestion(p)==1)
           return Result.buildResult(Result.Status.OK);
       else
           return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getKnowlegeP")
    public Result getKnowlegeP(Long userID){
        try{
            if(userID==null)
                return Result.buildResult(Result.Status.ERROR);
            return Result.buildResult(Result.Status.OK,questionMapper.getKnowlegdePoint(userID));
        }catch(Exception e){
            log.error("获取知识点出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByPoint")
    public Result getByPoint(Long ID){
        try{
            if(ID==null)
                return Result.buildResult(Result.Status.ERROR);
            return Result.buildResult(Result.Status.OK,questionMapper.getByPoint(ID));
        }catch(Exception e){
            log.error("获取知识点问题出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    //改成RequestBody
    @PostMapping("/getByPointStu")
    public Result getByPointStu(@RequestBody classInfoVO classInfoVO){
        try{

            if(classInfoVO==null)
                return Result.buildResult(Result.Status.ERROR);
            return Result.buildResult(Result.Status.OK,qService.getByPointStu(classInfoVO));
        }catch(Exception e){
            log.error("获取知识点问题出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    //学生回答问题
    @PostMapping("/StucommentQues")
    public Result StucommentQues(@RequestBody  StuCommentVO stuCommentVO){
        try{
            if(stuCommentVO==null){

                return Result.buildResult(Result.Status.ERROR);
            }

            stuCommentVO.setTdate(new Timestamp(System.currentTimeMillis()));

            questionMapper.StucommentQues(stuCommentVO);
            infoMapper.addScore(stuCommentVO.getStudentID());
           return Result.buildResult(Result.Status.OK);
        }catch(Exception e){
            log.error("学生"+stuCommentVO.getStudentID()+"回答问题"+stuCommentVO.getQuestionID()+"出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/TeacommentQues")
    public Result TeacommentQues(@RequestBody StuCommentVO sc){
        try{
            if(sc==null){
                return Result.buildResult(Result.Status.ERROR);
            }
            sc.setTdate(new Timestamp(System.currentTimeMillis()));
            return Result.buildResult(Result.Status.OK,questionMapper.TeacommentQues(sc));
        }catch(Exception e){
            log.error("教师ID为"+sc.getStudentID()+"回答问题"+sc.getQuestionID()+"出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }


    }



    @GetMapping("/QuestionByknowledge")
    public Result QuestionByknowledge(){
        try{

            return Result.buildResult(Result.Status.OK,questionMapper.getKnowledgeQues());
        }catch(Exception e){
            log.info("获取知识点关联问题信息出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Teapostquestion")
    public Result Teapostquestion(@RequestBody postquesVO p){

        if(p==null)
            return Result.buildResult(Result.Status.ERROR);
        if( qService.postTeaquestion(p)==1)
            return Result.buildResult(Result.Status.OK);
        else
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/getNoneTypeQues")
    public Result getNoneTypeQues(@RequestBody ogVO p){

        if(p==null)
            return Result.buildResult(Result.Status.ERROR);

            return Result.buildResult(Result.Status.OK,questionMapper.getNoneTypeQues(p.getObject(),p.getGrade()));
    }

    @PostMapping("/getNonePointQues")
    public Result getNonePointQues(@RequestBody ogVO p){
        System.out.println(p.getGrade()+p.getObject());
        if(p==null)
            return Result.buildResult(Result.Status.ERROR);
        return Result.buildResult(Result.Status.OK,questionMapper.getNonePointQues(p.getObject(),p.getGrade()));
    }

    @GetMapping("/getAllPointQues")
    public Result getAllPointQues(Long userID){

        try{
        if (userID==null)
            return Result.buildResult(Result.Status.ERROR);


        //获取知识点ID 知识点名称 问题ID 问题标题
        List<PointQuesDTO> quesDTOLists=questionMapper.getAllPointQues(userID);
        //最后传输的列表
        List<CollpaseDTO> collpaseDTOList=new ArrayList<>();


        //临时的交换列表 对象
        List<PointQuesDTO> tempLists;
        PointQuesDTO tempobject;


        List<PointQuesDTO> uniqLists=questionMapper.getAllPointUniq(userID);


        for (PointQuesDTO p:
             uniqLists) {
            collpaseDTOList.add(new CollpaseDTO(p.getKnowledgePoint()));
        }


        //放 子问题
        int i=0;
        for (CollpaseDTO cd:collpaseDTOList
        ){
            List<PointQuesDTO> tempo=new ArrayList<>();
            for (PointQuesDTO p:
                    quesDTOLists) {
                if (cd.getKnowledgepoint().equals(p.getKnowledgePoint()))
                    tempo.add(p);
            }

            collpaseDTOList.get(i).setList(tempo);
            i=i+1;
        }




        return Result.buildResult(Result.Status.OK,collpaseDTOList);
        }catch (Exception e){
            log.error("获取全部知识点问题出错"+e);
            return Result.buildResult(Result.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("postKnowRealteQues")
    public Result postKnowQues(@RequestBody postKnowQVO po){

        System.out.println(po.getIdLists());

        if (po.getPoindID()==null && po.getIdLists()==null)
            return Result.buildResult(Result.Status.ERROR);
        List<Long> pointlits=questionMapper.getQID(po.getPoindID());

//        int[] idarr= idLists.stream() .mapToInt(Integer::intValue) .toArray();

        int[] poarr=pointlits.stream() .mapToInt(Long::intValue) .toArray();
        List<List<Integer>> ad=findDifference(po.getIdLists(),poarr);

        List<KnowAddReaVO> addlist=new ArrayList<>();
        List<Long> dellist=new ArrayList<>();

        //新加
        for (int i:
                ad.get(0))
        {
            String id=i+"";
            addlist.add(new KnowAddReaVO(po.getPoindID(),Long.parseLong(id)));
        }

        //去除
        for (int i:
                ad.get(1))
        {
            String id=i+"";
            dellist.add(Long.parseLong(id));
        }

        if(addlist.size()!=0){

            questionMapper.addPrealteQues(addlist);
        }

        if (dellist.size()!=0){
            KnowRealteQuesVO o=new KnowRealteQuesVO(po.getPoindID(),dellist);
            System.out.println(o.getList());
            questionMapper.delPrealteQues(new KnowRealteQuesVO(po.getPoindID(),dellist));
        }


//        String temp=dellist.toString().replace("[","(").replace("]",")");
//
//
//        questionMapper.delPrealteQues(new KnowRealteQuesVO(po.getPoindID(),temp));
//        String tempadd=addlist.toString().replace("[","(").replace("]",")");


        return null;
    }


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        //list1和list2存储不同于对方的整数
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //先将nums1和nums2中的数据存入哈希表中
        for (int i = 0; i < nums1.length; i++) set1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) set2.add(nums2[i]);
        for (int i = 0; i < nums1.length; i++) {
            //防止重复添加
            if (!set2.contains(nums1[i]) && !list1.contains(nums1[i])) list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            //防止重复添加
            if (!set1.contains(nums2[i]) && !list2.contains(nums2[i])) list2.add(nums2[i]);
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }


    @PostMapping("addnewKnow")
    public Result addnewKnow(@RequestBody konwledgepoint k){

        if (k==null)
            return Result.buildResult(Result.Status.ERROR);


            questionMapper.addnewknow(k);
            Long KID=questionMapper.getKnowID(k.getTeacherID(),k.getKnowledgePoint());
        return Result.buildResult(Result.Status.OK,KID);
    }


    @PostMapping("FirstnewKnow")
    public Result FirstnewKnow(@RequestBody postKnowQVO po){


                System.out.println("已进入");
                if (po.getIdLists()==null && po.getPoindID()==null)
                    return Result.buildResult(Result.Status.ERROR);

                List<KnowAddReaVO> addlist=new ArrayList<>();
                for (int tmp:
                        po.getIdLists()) {
                    String stmp=tmp+"";
                    addlist.add(new KnowAddReaVO(po.getPoindID(),Long.parseLong(stmp)));
                }
                questionMapper.addPrealteQues(addlist);
                return Result.buildResult(Result.Status.OK);




    }



}
