package com.uhiroshi.biyesheji.service;

import com.uhiroshi.biyesheji.pojo.vo.AdminInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.StuInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.TeaherInfoVO;
import com.uhiroshi.biyesheji.pojo.vo.userInfoVO;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

public interface infoService {
    List<String> getobject(Integer grade);

    userInfoVO getStuInfo(Long userID);

    userInfoVO getTeacherInfo(Long userID);

    userInfoVO getAdminInfo(Long userID);

}
