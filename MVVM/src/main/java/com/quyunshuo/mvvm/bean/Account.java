package com.quyunshuo.mvvm.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @Author: MiYan
 * @Time: 2019/11/14 16:33
 * @Description: 描述：
 */
public class Account extends BaseObservable {
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

    @Bindable
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
        notifyPropertyChanged(com.quyunshuo.mvvm.BR.grade);
    }
}
