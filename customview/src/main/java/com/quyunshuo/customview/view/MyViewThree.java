package com.quyunshuo.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * @Author: MiYan
 * @Time: 2019/10/14 13:49
 * @Description: 描述：
 */
public class MyViewThree extends View {
    public MyViewThree(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        //圆形路径
        //void addCircle (float x, float y, float radius, Path.Direction dir)
        //参数说明：
        //float x：圆心X轴坐标 
        //float y：圆心Y轴坐标
        //float radius：圆半径
        Path path5 = new Path();
        paint.setColor(Color.YELLOW);
        path5.addCircle(500, 500, 300, Path.Direction.CCW);
        canvas.drawPath(path5, paint);

        //椭圆路径
        //void addArc (RectF oval, float startAngle, float sweepAngle)
        //参数：
        //RectF oval：弧是椭圆的一部分，这个参数就是生成椭圆所对应的矩形；
        //float startAngle：开始的角度，X轴正方向为0度
        //float sweepAngel：持续的度数；
        Path path = new Path();
        RectF rectF = new RectF(50,50,240,200);
        path.addArc(rectF,0,200);
        canvas.drawPath(path,paint);
    }
}
