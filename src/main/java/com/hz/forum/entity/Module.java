package com.hz.forum.entity;

import java.io.Serializable;

/**
 * Created by 11022 on 2019/2/22 0022.
 */
public class Module implements Serializable{
    private String moduleId;
    private String moduleName;
    private String moduleLevel;
    private String moduleTroduce;
    public Module() {
    }

    public Module(String moduleId, String moduleName, String moduleLevel, String moduleTroduce) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleLevel = moduleLevel;
        this.moduleTroduce = moduleTroduce;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleLevel() {
        return moduleLevel;
    }

    public void setModuleLevel(String moduleLevel) {
        this.moduleLevel = moduleLevel;
    }

    public String getModuleTroduce() {
        return moduleTroduce;
    }

    public void setModuleTroduce(String moduleTroduce) {
        this.moduleTroduce = moduleTroduce;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId='" + moduleId + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", moduleLevel='" + moduleLevel + '\'' +
                ", moduleTroduce='" + moduleTroduce + '\'' +
                '}';
    }
}
