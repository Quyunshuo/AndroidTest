package com.quyunshuo.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import java.lang.reflect.MalformedParameterizedTypeException;

/**
 * @Author: MiYan
 * @Time: 2019/10/15 11:09
 * @Description: 描述：
 */
public class MyViewFour extends View {

    private Paint mPaint = new Paint();

    public MyViewFour(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        differenceInDrawingStyle(canvas);
//        textStyleDifference(canvas);
//        textHorizontalStretching(canvas);
        textOnPath(canvas);
    }

    /**
     * Paint 相关设置
     */
    private void mPaintRelated() {
        //普通设置
        mPaint.setStrokeWidth(5);       //设置画笔宽度
        mPaint.setAntiAlias(true);      //指定是否使用抗锯齿功能 如果使用会使绘图速度变慢
        mPaint.setStyle(Paint.Style.FILL);//绘图样式 对于设置文字和几何图形都有效
        mPaint.setTextAlign(Paint.Align.CENTER);//设置文字对齐方式 取值：Align.CENTER Align.LEFT Align.RIGHT
        mPaint.setTextSize(12);         //设置文字大小

        //样式设置
        mPaint.setFakeBoldText(true);   //设置是否为粗体文字
        mPaint.setUnderlineText(true);  //设置下划线
        mPaint.setTextSkewX(-0.25f);    //设置字体水平倾斜度 普通斜体字是-0.25
        mPaint.setStrikeThruText(true); //设置带有删除线效果

        //其他设置
        mPaint.setTextScaleX(2);        //只会将水平方向拉伸，高度不会变
    }

    /**
     * 绘图样式的区别
     */
    private void differenceInDrawingStyle(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(120);

        //绘图样式设置为填充
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("AndroidTextProject", 10, 120, mPaint);
        //绘图样式设置为描边
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawText("AndroidTextProject", 10, 240, mPaint);
        //绘图样式设置为填充且描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("AndroidTextProject", 10, 360, mPaint);
    }

    /**
     * 文字设置样式及倾斜度正负区别
     */
    private void textStyleDifference(Canvas canvas) {
        mPaint.setColor(Color.RED);  //设置画笔颜色
        mPaint.setStrokeWidth(5);//设置画笔宽度
        mPaint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        mPaint.setTextSize(80);//设置文字大小
        mPaint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充	

        //样式设置
        mPaint.setFakeBoldText(true);//设置是否为粗体文字
        mPaint.setUnderlineText(true);//设置下划线
        mPaint.setStrikeThruText(true);//设置带有删除线效果

        //设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜
        mPaint.setTextSkewX((float) -0.25);
        canvas.drawText("AndroidTextProject", 10, 100, mPaint);

        //水平倾斜度设置为：0.25，往左斜
        mPaint.setTextSkewX((float) 0.25);
        canvas.drawText("AndroidTextProject", 10, 200, mPaint);
    }

    /**
     * 文字水平拉伸设置
     */
    private void textHorizontalStretching(Canvas canvas) {
        mPaint.setColor(Color.RED);  //设置画笔颜色
        mPaint.setStrokeWidth(5);//设置画笔宽度
        mPaint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        mPaint.setTextSize(80);//设置文字大小
        mPaint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充	

        //变通样式字体
        canvas.drawText("AndroidTextProject", 10, 100, mPaint);

        //水平方向拉伸两倍
        mPaint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变
        canvas.drawText("AndroidTextProject", 10, 200, mPaint);

        //写在同一位置,不同颜色,看下高度是否看的不变
        mPaint.setTextScaleX(1);//先还原拉伸效果
        canvas.drawText("AndroidTextProject", 10, 300, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setTextScaleX(2);//重新设置拉伸效果
        canvas.drawText("AndroidTextProject", 10, 300, mPaint);
    }

    /**
     * 沿路径绘制
     */

    private void textOnPath(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(45);
        mPaint.setStyle(Paint.Style.STROKE);

        String string = "风萧萧兮易水寒，壮士一去兮不复还";

        //先创建两个相同的圆形路径，并画出两个路径原图
        Path circlePath = new Path();
        circlePath.addCircle(220, 200, 180, Path.Direction.CCW); //逆向绘制
        canvas.drawPath(circlePath, mPaint);

        Path circlePath2 = new Path();
        circlePath2.addCircle(750, 200, 180, Path.Direction.CCW);
        canvas.drawPath(circlePath2, mPaint);

        mPaint.setColor(Color.GREEN);

        //hOffset、vOffset参数值全部设为0，看原始状态是怎样的
        canvas.drawTextOnPath(string, circlePath, 0, 0, mPaint);
        //第二个路径，改变hOffset、vOffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80, 30, mPaint);
    }

    /**
     * 字体样式设置
     */
    private void textTypeface(Canvas canvas) {


    }

}
