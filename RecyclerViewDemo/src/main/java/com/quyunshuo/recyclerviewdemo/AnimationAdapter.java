package com.quyunshuo.recyclerviewdemo;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @Author: MiYan
 * @Time: 2019/7/30 10:48
 * @see:
 * @Company:
 * @Description: 功能描述
 * 创建数据适配器继承BaseQuickAdapter<K,T> 第一个参数传入数据实体类、第二个传入BaseViewHolder
 * 重写convert()方法和构造方法
 */
public class AnimationAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    //传入item布局id和数据
    public AnimationAdapter(int layoutResId, @Nullable List<Status> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        //给指定ID View添加OnClickListener
        helper.addOnClickListener(R.id.iv)
                .addOnClickListener(R.id.tv);
        //动态设置ImageView的图片
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.iv, R.mipmap.animation_img3);
                break;
            default:
                break;
        }
    }
}
