package com.quyunshuo.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/**
 * @Author: MiYan
 * @Time: 2019/10/14 10:56
 * @Description: 描述：
 */
public class MyView extends View {
    Context mContext;

    public MyView(Context context) {
        super(context);
        mContext = context;
    }

    /**
     * 重写OnDraw（）函数，在每次重绘时自主实现绘图
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔基本属性
        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿功能
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影

        //设置画布背景颜色
        canvas.drawRGB(255, 255, 255);

        //画圆
        canvas.drawCircle(190, 200, 150, paint);

        //画直线
        canvas.drawLine(400, 400, 500, 500, paint);

        //画多条直线
        float[] pts = {400, 500, 400, 600, 500, 500, 500, 600};
        canvas.drawLines(pts, paint);

        //画点
        canvas.drawPoint(600, 700, paint);

        //画多个点
        //float[] pts:点的合集，与上面直线一直，样式为｛x1,y1,x2,y2,x3,y3,……｝
        //int offset:集合中跳过的数值个数，注意不是点的个数！一个点是两个数值；
        //count:参与绘制的数值的个数，指pts[]里人数值个数，而不是点的个数，因为一个点是两个数值
        paint.setColor(Color.GREEN);
        float[] pts2 = {10, 10, 100, 100, 200, 200, 400, 400};
        canvas.drawPoints(pts2, 2, 4, paint);

        //画矩形
        canvas.drawRect(10, 10, 100, 100, paint);//直接构造

        RectF rect = new RectF(120, 10, 210, 100);
        canvas.drawRect(rect, paint);//使用RectF构造

        Rect rect2 =  new Rect(230, 10, 320, 100);
        canvas.drawRect(rect2, paint);//使用Rect构造

        //画圆角矩形
        RectF rect3 = new RectF(400, 10, 700, 100);
        canvas.drawRoundRect(rect3, 20, 10, paint);

        //画椭圆
        //椭圆是根据矩形生成的，以矩形的长为椭圆的X轴，矩形的宽为椭圆的Y轴，建立的椭圆图形
        paint.setColor(Color.YELLOW);//更改画笔颜色

        paint.setStyle(Paint.Style.STROKE);
        RectF rect4 = new RectF(100, 410, 300, 500);
        canvas.drawRect(rect4, paint);//画矩形

        paint.setColor(Color.CYAN);//更改画笔颜色
        canvas.drawOval(rect4, paint);//同一个矩形画椭圆

        //画弧
        //弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；
        //RectF oval:生成椭圆的矩形
        //float startAngle：弧开始的角度，以X轴正方向为0度
        //float sweepAngle：弧持续的角度
        //boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧
        RectF rect5 = new RectF(100, 400, 300, 500);
        canvas.drawArc(rect5, 0, 90, true, paint);

        RectF rect6 = new RectF(400, 400, 600, 500);
        canvas.drawArc(rect6, 0, 90, false, paint);


    }
}
