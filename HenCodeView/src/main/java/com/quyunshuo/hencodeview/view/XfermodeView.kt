package com.quyunshuo.hencodeview.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.quyunshuo.hencodeview.utils.px

// 模式
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)

/**
 * Xfermode示例
 *
 * @author Qu Yunshuo
 * @since 2/28/21 4:15 PM
 */
class XfermodeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(150f.px, 50f.px, 300f.px, 200f.px)
    private val circleBitmap = Bitmap.createBitmap(150f.px.toInt(), 150f.px.toInt(), Bitmap.Config.ARGB_8888)
    private val squareBitmap = Bitmap.createBitmap(150f.px.toInt(), 150f.px.toInt(), Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(circleBitmap)
        // 在circleBitmap画出圆形图像
        paint.color = Color.parseColor("#D81B60")
        canvas.drawOval(50f.px, 0f.px, 150f.px, 100f.px, paint)
        // 在squareBitmap画出方形图像
        paint.color = Color.parseColor("#2196F3")
        canvas.setBitmap(squareBitmap)
        canvas.drawRect(0f.px, 50f.px, 100f.px, 150f.px, paint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = canvas.saveLayer(bounds, null)
        canvas.drawBitmap(circleBitmap, 150f.px, 50f.px, paint)
        // 设置xfermode
        paint.xfermode = XFERMODE
        canvas.drawBitmap(squareBitmap, 150f.px, 50f.px, paint)
        // 使用完要重置xfermode
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}