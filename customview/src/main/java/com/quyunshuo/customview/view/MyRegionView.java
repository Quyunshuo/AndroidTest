package com.quyunshuo.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.view.View;

/**
 * @Author: MiYan
 * @Time: 2019/10/15 14:14
 * @Description: 描述：
 */
public class MyRegionView extends View {

    public MyRegionView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        construction(canvas);
    }

    /**
     * 构造区域
     */
    private void construction(Canvas canvas) {
        //初始化画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);

        Region rgn = new Region(10, 10, 100, 100);

//        rgn.set(100, 100, 200, 200);
        drawRegion(canvas, rgn, paint);
    }

    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();
        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }
}