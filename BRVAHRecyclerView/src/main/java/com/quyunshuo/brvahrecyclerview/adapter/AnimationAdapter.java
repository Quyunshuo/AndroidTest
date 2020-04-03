package com.quyunshuo.brvahrecyclerview.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.quyunshuo.brvahrecyclerview.R;
import com.quyunshuo.brvahrecyclerview.data.DataServer;
import com.quyunshuo.brvahrecyclerview.data.Status;
import com.quyunshuo.brvahrecyclerview.utils.ClickableMovementMethod;
import com.quyunshuo.brvahrecyclerview.utils.SpannableStringUtils;
import com.quyunshuo.brvahrecyclerview.utils.ToastUtils;
import com.quyunshuo.brvahrecyclerview.utils.Utils;

/**
 * @Author: MiYan
 * @Time: 2019/8/14 20:37
 * @Description: 描述：
 */
public class AnimationAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    //构造方法里直接传入了item布局和数据源
    public AnimationAdapter() {
        super(R.layout.animation_item, DataServer.getSampleData(100));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        //给指定控件set点击事件
        helper.addOnClickListener(R.id.imgView).addOnClickListener(R.id.text);
        //item背景使用switch()设置
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.imgView, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.imgView, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.imgView, R.mipmap.animation_img3);
                break;
            default:
                break;
        }
        //给item的标题设置text
        helper.setText(R.id.text, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";

        ((TextView) helper.getView(R.id.text2)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.text2)).setMovementMethod(ClickableMovementMethod.getInstance());
        ((TextView) helper.getView(R.id.text2)).setFocusable(false);
        //设置不可点击
        ((TextView) helper.getView(R.id.text2)).setClickable(false);
        //设置不可长按
        ((TextView) helper.getView(R.id.text2)).setLongClickable(false);
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        //点击事件
        @Override
        public void onClick(View widget) {
//            ToastUtils.showShortToast("事件触发了 landscapes and nedes");//使程序崩溃
            Toast.makeText(mContext, "事件触发了 landscapes and nedes", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(mContext.getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
