package com.quyunshuo.hencodeview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.quyunshuo.hencodeview.utils.px
import kotlin.math.cos
import kotlin.math.sin

// 半径
private val RADIUS = 150f.px

// 预设的角度
private val ANGLES = floatArrayOf(60f, 90f, 150f, 60f)

// 偏移长度
private val OFFSET_LENGTH = 20f.px

// 预设的颜色
private val COLORS = listOf(
        Color.parseColor("#C2185B"),
        Color.parseColor("#00ACC1"),
        Color.parseColor("#558B2F"),
        Color.parseColor("#5D4037"))

/**
 * 饼图
 *
 * @author Qu Yunshuo
 * @since 2/28/21 2:45 PM
 */
class PieView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    // Paint.ANTI_ALIAS_FLAG 此标记会让画笔开启抗锯齿
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 画弧
        // 开始角度
        var startAngle = 25f
        // 遍历预设的角度 循环绘制出各个饼
        for ((index, angle) in ANGLES.withIndex()) {
            // 设置画笔颜色
            paint.color = COLORS[index]

            // 将第一块饼 朝外移动
            if (index == 0) {
                // 保存图层
                canvas.save()
                // 计算图层移动距离 并移动
                canvas.translate(
                        OFFSET_LENGTH * cos(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat(),
                        OFFSET_LENGTH * sin(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat()
                )
            }

            // 绘制出饼
            canvas.drawArc(width / 2 - RADIUS, height / 2 - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS, startAngle, angle, true, paint)

            // 记录当前已经绘制的角度 供下次绘制使用
            startAngle += angle
            if (index == 0) {
                // 恢复图层
                canvas.restore()
            }
        }
    }
}