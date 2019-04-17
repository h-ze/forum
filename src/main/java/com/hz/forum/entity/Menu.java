package com.hz.forum.entity;

import java.io.Serializable;

/**
 * Created by 11022 on 2019/2/22 0022.
 */
public class Menu implements Serializable{
    private String menuId;
    private String menuName;
    private String menuType;
    private String menuUrl;
    private String menuLevel;
    private Integer menuParentId;

    public Menu() {
    }

    public Menu(String menuId, String menuName, String menuType, String menuUrl, String menuLevel, Integer menuParentId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuType = menuType;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuType='" + menuType + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuParentId=" + menuParentId +
                '}';
    }
}
