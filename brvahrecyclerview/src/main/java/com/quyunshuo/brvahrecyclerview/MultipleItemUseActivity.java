package com.quyunshuo.brvahrecyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.quyunshuo.brvahrecyclerview.adapter.MultipleItemQuickAdapter;
import com.quyunshuo.brvahrecyclerview.base.BaseActivity;
import com.quyunshuo.brvahrecyclerview.data.DataServer;
import com.quyunshuo.brvahrecyclerview.data.MultipleItem;

import java.util.List;

/**
 * @Author: MiYan
 * @Time: 2019/8/15 18:32
 * @Description: 描述：
 */
public class MultipleItemUseActivity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);
        initView();
    }

    private void initView() {
        setTitle("MultipleItem Use");
        setBackBtn();
        recyclerView = findViewById(R.id.recycler);
        final List<MultipleItem> data = DataServer.getMultipleItemData();
        MultipleItemQuickAdapter adapter = new MultipleItemQuickAdapter(data);
        //设置屏幕宽度为4个维度
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        //获取数据里设置的维度
        //数据里的数据设置的是6个一循环  这样数据1和2的维度加起来是4正好是一行 数据3的维度是4占一行 数据4和5加起来是4占一行
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int i) {
                return data.get(i).getSpanSize();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
