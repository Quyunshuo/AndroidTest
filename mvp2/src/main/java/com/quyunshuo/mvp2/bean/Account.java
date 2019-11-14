package com.quyunshuo.mvp2.bean;

/**
 * @Author: MiYan
 * @Time: 2019/11/14 16:33
 * @Description: 描述：
 */
public class Account {
    public Account(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    private String name;
    private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
