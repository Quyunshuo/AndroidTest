package com.quyunshuo.mvpdemo.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.quyunshuo.mvpdemo.R;
import com.quyunshuo.mvpdemo.bean.ComicListInfo;
import com.quyunshuo.mvpdemo.mvp.ContractComic;
import com.quyunshuo.mvpdemo.mvp.presenter.Presenter;

import java.util.List;

public class ViewActivity extends AppCompatActivity implements ContractComic.View {
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        //获取P层的实例
        mPresenter = new Presenter();
        //把当前的View层实例传递给P层
        mPresenter.attachView(this);
        //请求数据
        mPresenter.requestList();
    }

    @Override
    public void showList(List<ComicListInfo.EntriesBean> comicListInfos) {
        Toast.makeText(this, "首页数据：" + comicListInfos.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "加载首页数据...", Toast.LENGTH_SHORT).show();
    }

    /**
     * 在销毁界面时销毁依赖对象
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
