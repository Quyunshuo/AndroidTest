package com.quyunshuo.mvvm.mvvm;

import android.app.Application;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.quyunshuo.mvvm.BR;
import com.quyunshuo.mvvm.bean.Account;
import com.quyunshuo.mvvm.callback.MCallback;
import com.quyunshuo.mvvm.databinding.ActivityMvvmBinding;

public class MvvmViewModel extends BaseObservable {
    private String result;
    private String userInput;
    private MvvmModel mvvmModel;

    //一般需要传入Application对象，方便在ViewModel中使用Application
    public MvvmViewModel(Application application) {
        mvvmModel = new MvvmModel();
    }

    public void getData(View view) {
        mvvmModel.getAccountData(userInput, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                String info = account.getName() + "|" + account.getGrade();
                setResult(info);
            }

            @Override
            public void onFailed() {
                setResult("获取数据失败");
            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(com.quyunshuo.mvvm.BR.result);
    }

    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(com.quyunshuo.mvvm.BR.userInput);
    }
}
