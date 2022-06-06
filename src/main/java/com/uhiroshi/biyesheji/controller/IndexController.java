package com.uhiroshi.biyesheji.controller;


import com.uhiroshi.biyesheji.common.Result;
import com.uhiroshi.biyesheji.mapper.infoMapper;
import com.uhiroshi.biyesheji.pojo.vo.userInfoVO;
import com.uhiroshi.biyesheji.service.infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;




@RestController
public class IndexController {
@Autowired
private infoMapper infoMapper;
@Autowired
private infoService iService;


    /**
     * 登录
     * @param username
     * @param password
     * @param httpSession
     * @return
     */
        @RequestMapping("login")
        public Result login(Long username, String password, HttpSession httpSession){

            //用户ID尾数 决定身份
            int userAuthriztionLength=username.toString().length();
            //判断用户 账户密码是否正确
            if(infoMapper.login(username).equals(password))
            {
                httpSession.setAttribute("userID",username.toString());
                return Result.buildResult(Result.Status.OK,
                                    acquireUser(userAuthriztionLength,username));
            }
            else
                return Result.buildResult(Result.Status.PWD_EEOR);
        }


    /**
     * 根据用户名长度 识别用户身份    返回用户基本信息
     * @param userAuthLength
     * @param username
     * @return
     */
    public userInfoVO acquireUser(int userAuthLength, Long username){
            if(userAuthLength >= 10)
                return iService.getStuInfo(username);
            else if(userAuthLength >= 8)
                return iService.getTeacherInfo(username);
            else
                return iService.getAdminInfo(username);
    }

        @RequestMapping("logout")
        public Result logout(HttpSession session){
            session.invalidate();
            return Result.buildResult(Result.Status.OK);
        }



}