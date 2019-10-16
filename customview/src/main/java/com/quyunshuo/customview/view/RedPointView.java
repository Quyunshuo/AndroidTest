package com.quyunshuo.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.quyunshuo.customview.R;

/**
 * @Author: MiYan
 * @Time: 2019/10/16 15:09
 * @Description: 描述：
 */
public class RedPointView extends FrameLayout {
    private PointF mStartPoint; //起始圆心位置
    private PointF mCurPoint;   //当前手指位置
    private float DEFAULT_RADIUS = 30;
    private float mRadius = DEFAULT_RADIUS;   //半径
    private Paint mPaint;       //画笔
    private Path mPath;         //路径
    private boolean mTouch;     //手指是否是下按状态
    private TextView mTextView;

    public RedPointView(@NonNull Context context) {
        super(context);
        initView();
    }

    public RedPointView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RedPointView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        mStartPoint = new PointF(100, 100);
        mCurPoint = new PointF();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();

        //添加一个TextView
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mTextView = new TextView(getContext());
        mTextView.setLayoutParams(params);
        mTextView.setPadding(10, 10, 10, 10);
        mTextView.setBackgroundResource(R.drawable.tv_bg);
        mTextView.setTextColor(Color.GREEN);
        mTextView.setText("99+");
        addView(mTextView);
    }

    /**
     * 因为FrameLayout是继承于ViewGroup所以要重写dispatchDraw()方法  而不是onDraw()方法
     *
     * @param canvas
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        //保存当前画布的位置信息和裁剪信息，新建画布在与上一层画布合成时，不清空原画布内容
        canvas.saveLayer(new RectF(0, 0, getWidth(), getHeight()), mPaint, Canvas.ALL_SAVE_FLAG);
        //判断手指是否为下按状态
        if (mTouch) {
            //计算轨迹
            calculatePath();
            //绘制一个圆
            canvas.drawCircle(mStartPoint.x, mStartPoint.y, mRadius, mPaint);
            //如果手指下按则绘制一个圆
            canvas.drawCircle(mCurPoint.x, mCurPoint.y, mRadius, mPaint);
            //绘制轨迹
            canvas.drawPath(mPath, mPaint);
            //将TextView的中心放在触摸点的中心
            mTextView.setX(mCurPoint.x - (int) (mTextView.getWidth() / 2));
            mTextView.setY(mCurPoint.y - (int) (mTextView.getHeight() / 2));
        } else {
            mTextView.setX(mStartPoint.x - (int) (mTextView.getWidth() / 2));
            mTextView.setY(mStartPoint.y - (int) (mTextView.getHeight() / 2));
        }
        //恢复栈顶画布并绘制
        canvas.restore();
        super.dispatchDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            //按下时
            case MotionEvent.ACTION_DOWN: {
                //判断触摸点是否在TextView中
                Rect rect = new Rect();
                int[] location = new int[2];
                mTextView.getLocationOnScreen(location);
                rect.left = location[0];
                rect.top = location[1];
                rect.right = mTextView.getWidth() + location[0];
                rect.bottom = mTextView.getHeight() + location[1];
                //判断触摸点是否在rect矩形内
                if (rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    mTouch = true;
                }
                break;
            }

            //拿起时
            case MotionEvent.ACTION_UP: {
                mTouch = false;
                break;
            }
        }
        mCurPoint.set(event.getX(), event.getY());
        //强制重绘
        postInvalidate();
        //当前消息到此为止，不再往父控件传递
        return true;
    }

    /**
     * 计算轨迹
     */
    private void calculatePath() {
        float x = mCurPoint.x;
        float y = mCurPoint.y;
        float startX = mStartPoint.x;
        float startY = mStartPoint.y;

        //根据三角函数计算出四边形的四个点
        float dx = x - startX;
        float dy = y - startY;
        double a = Math.atan(dy / dx);
        float offsetX = (float) (mRadius * Math.sin(a));
        float offsetY = (float) (mRadius * Math.cos(a));

        //根据拉伸长度来改变圆的半径
        float distance = (float) Math.sqrt(Math.pow(y - startY, 2) + Math.pow(x - startX, 2));
        mRadius = DEFAULT_RADIUS - distance / 15;
        if (mRadius < 9) {
            mRadius = 9;
        }

        float x1 = startX + offsetX;
        float y1 = startY - offsetY;

        float x2 = x + offsetX;
        float y2 = y - offsetY;

        float x3 = x - offsetX;
        float y3 = y + offsetY;

        float x4 = startX - offsetX;
        float y4 = startY + offsetY;

        //两圆心连线的中点 即贝赛尔曲线的控制点
        float anchorX = (startX + x) / 2;
        float anchorY = (startY + y) / 2;

        //把四个点连接起来
        mPath.reset();
        mPath.moveTo(x1, y1);                   //起点
        mPath.quadTo(anchorX, anchorY, x2, y2); //贝赛尔曲线
        mPath.lineTo(x3, y3);                   //直线
        mPath.quadTo(anchorX, anchorY, x4, y4); //贝赛尔曲线
        mPath.lineTo(x1, y1);                   //直线
    }
}
