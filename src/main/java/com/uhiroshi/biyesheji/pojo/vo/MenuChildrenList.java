package com.uhiroshi.biyesheji.pojo.vo;

public class MenuChildrenList {
    private String menuName;
    private String url;


    public MenuChildrenList(String menuName, String url) {
        this.menuName = menuName;
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
