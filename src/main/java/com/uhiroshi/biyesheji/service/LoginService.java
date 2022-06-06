package com.uhiroshi.biyesheji.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class LoginService {

   /* public User getUserbyName(String getbyname){
        return getMapByName(getbyname);
    }

    private User getMapByName(String username){
        permissions p1= new permissions(1,"query");
        permissions p2=new permissions(2,"add");
        Set<permissions> permissionsSet=new HashSet<>();
        permissionsSet.add(p1);
        permissionsSet.add(p2);

        Role role=new Role(1,"admin",permissionsSet);

        Set<Role> roleSet= new HashSet<>();
        roleSet.add(role);

        User user=new User(1,"uhiroshi","123",roleSet);
        Map<String,User> map = new HashMap<>();
        map.put(user.getName(),user);



        //User权能
        Set<permissions> permissionsSet1=new HashSet<>();
        permissionsSet1.add(p1);

        Role role1=new Role(2,"user",permissionsSet1);
        Set<Role> roleSet1=new HashSet<>();
        roleSet1.add(role1);

        User user1= new User(2,"zhangsan","1234",roleSet1);
        map.put(user1.getName(),user1);
        return map.get(username);

    }*/
}