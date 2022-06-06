package com.uhiroshi.biyesheji.pojo.vo;

public class menurlVO {
    private String menuname;
    private String url;

    public menurlVO(String menuname, String url) {
        this.menuname = menuname;
        this.url = url;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
