package com.uhiroshi.biyesheji.pojo.vo;

import java.util.List;

public class MenuList {


    private String menuName;
    private List<MenuChildrenList> children;
    private String url;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<MenuChildrenList> getChildren() {
        return children;
    }

    public void setChildren(List<MenuChildrenList> children) {
        this.children = children;
    }
}
