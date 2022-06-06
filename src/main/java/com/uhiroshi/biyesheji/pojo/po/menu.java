package com.uhiroshi.biyesheji.pojo.po;


public class menu {
    private Integer menuID;
    private Integer IsParent;
    private String menuName;
    private Integer childrenID;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsParent() {
        return IsParent;
    }

    public void setIsParent(Integer isParent) {
        IsParent = isParent;
    }

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getChildrenID() {
        return childrenID;
    }

    public void setChildrenID(Integer childrenID) {
        this.childrenID = childrenID;
    }
}
