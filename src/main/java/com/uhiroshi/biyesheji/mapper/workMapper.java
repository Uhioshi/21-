package com.uhiroshi.biyesheji.mapper;

import com.uhiroshi.biyesheji.pojo.dto.AvgVO;
import com.uhiroshi.biyesheji.pojo.dto.NewWorkDTO;
import com.uhiroshi.biyesheji.pojo.dto.StuWorkDTO;
import com.uhiroshi.biyesheji.pojo.dto.StuWorkDetalDTO;
import com.uhiroshi.biyesheji.pojo.po.homework;
import com.uhiroshi.biyesheji.pojo.po.stuhomework;
import com.uhiroshi.biyesheji.pojo.vo.NOgVO;
import com.uhiroshi.biyesheji.pojo.vo.ogVO;

import java.util.List;

public interface workMapper {
    List<homework> getWork(Long userID);

    List<StuWorkDetalDTO> getStuwork(Long homeworkID);

    stuhomework getStuworkByID(Long stuworkID);

    int postInfo(StuWorkDTO workDTO);

    int addNewWork(NewWorkDTO newworkDTO);

    List<homework> getWorkByObject(NOgVO og);

    homework getWorkinfo(Long workID);

    int postStuWork(stuhomework sh);

    List<AvgVO> avgList();

    int upstuscore(AvgVO list);

    List<stuhomework> getBeenModiWork(Long studentID);

    Long getStuIDFromSW(Long stuworkID);





}
