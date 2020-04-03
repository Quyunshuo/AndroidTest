package com.quyunshuo.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author: MiYan
 * @Time: 2019/10/15 16:18
 * @Description: 描述：贝塞尔曲线
 */
public class MyViewFive extends View {
    public MyViewFive(Context context) {
        super(context);
    }

    public MyViewFive(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(6);

        Path path = new Path();
        path.moveTo(100, 300);      //起点
        path.quadTo(200, 200, 300, 300); //第一条二阶贝塞尔曲线
        path.quadTo(400, 400, 500, 300); //第二条二阶贝塞尔曲线

        canvas.drawPath(path, paint);
    }
}
