package com.quyunshuo.brvahrecyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.quyunshuo.brvahrecyclerview.R;
import com.quyunshuo.brvahrecyclerview.data.HomeItem;

import java.util.List;

/**
 * @Author: MiYan
 * @Time: 2019/8/14 17:15
 * @Description: 描述：Home RecyclerViewAdapter
 */
public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {
    //重写构造方法
    public HomeAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    //item
    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        //设置每个条目的Title
        helper.setText(R.id.text, item.getTitle());
        //设置每个条目的icon
        helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
