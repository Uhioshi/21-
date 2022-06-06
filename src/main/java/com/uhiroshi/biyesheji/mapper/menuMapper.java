package com.uhiroshi.biyesheji.mapper;

import com.uhiroshi.biyesheji.pojo.po.menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public  interface menuMapper {
     List<menu> menulist();
}
