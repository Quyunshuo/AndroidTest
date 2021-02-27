package com.quyunshuo.hencodeview.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.quyunshuo.hencodeview.utils.px
import kotlin.math.cos
import kotlin.math.sin

// 半径
private val RADIUS = 150f.px

// 开角
private const val OPEN_ANGLE = 120f

// 刻度宽
private val DASH_WIDTH = 2f.px

// 刻度长
private val DASH_LENGTH = 10f.px

// 指针长度
private val LENGTH = 120f.px

private const val MARK = 2

/**
 * 仪表盘自定义View
 *
 * @author Qu Yunshuo
 * @since 2/27/21 9:21 PM
 */
class DashboardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    // 弧
    private val path = Path()

    // 刻度
    private val dash = Path().apply {
        addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
    }

    private val paint = Paint().apply {
        strokeWidth = 3f.px
        style = Paint.Style.STROKE
    }

    private lateinit var pathEffect: PathEffect

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // 清除路径中的所有直线和曲线，使其为空。这不会更改填充类型设置
        path.reset()
        // 将指定的弧添加到路径作为新轮廓
        path.addArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS, 90 + OPEN_ANGLE / 2f, 360 - OPEN_ANGLE)
        // 测量路径
        val pathMeasure = PathMeasure(path, false)
        pathEffect = PathDashPathEffect(dash, (pathMeasure.length - DASH_WIDTH) / 20f, 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 画弧
        canvas.drawPath(path, paint)

        // 画刻度
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null

        // 画指针
        canvas.drawLine(width / 2f, height / 2f,
                width / 2f + LENGTH * cos(markToRadians(MARK)).toFloat(),
                height / 2f + LENGTH * sin(markToRadians(MARK)).toFloat(), paint)
    }

    private fun markToRadians(mark: Int): Double =
            Math.toRadians((90 + OPEN_ANGLE / 2f + (360 - OPEN_ANGLE) / 20f * mark).toDouble())
}