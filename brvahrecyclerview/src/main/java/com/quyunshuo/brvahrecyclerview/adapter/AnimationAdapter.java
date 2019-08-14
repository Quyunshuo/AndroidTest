package com.quyunshuo.brvahrecyclerview.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

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

import java.util.List;

/**
 * @Author: MiYan
 * @Time: 2019/8/14 20:37
 * @Description: 描述：
 */
public class AnimationAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {

    public AnimationAdapter(int layoutResId, @Nullable List<Status> data) {
        super(R.layout.animation_item, DataServer.getSampleData(100));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        helper.addOnClickListener(R.id.imgView).addOnClickListener(R.id.text);
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
        helper.setText(R.id.text, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) helper.getView(R.id.text)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.text)).setMovementMethod(ClickableMovementMethod.getInstance());
        ((TextView) helper.getView(R.id.text)).setFocusable(false);
        ((TextView) helper.getView(R.id.text)).setClickable(false);
        ((TextView) helper.getView(R.id.text)).setLongClickable(false);
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
