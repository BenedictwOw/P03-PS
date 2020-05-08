package com.myapplicationdev.android.p03_classjournal;

public class Module {
    private String module;
    private String name;

    public Module(String module, String name) {
        this.module = module;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Module{" +
                "module='" + module + '\'' +
                '}';
    }
}
