package com.quyunshuo.brvahrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.quyunshuo.brvahrecyclerview.adapter.MultipleItemQuickAdapter;
import com.quyunshuo.brvahrecyclerview.base.BaseActivity;
import com.quyunshuo.brvahrecyclerview.data.DataServer;
import com.quyunshuo.brvahrecyclerview.data.MultipleItem;

import java.util.List;

public class MultipleItemRvAdapterUseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplel_item_rv_adapter_use);

    }
}
