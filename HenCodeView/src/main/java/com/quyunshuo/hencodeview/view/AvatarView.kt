package com.quyunshuo.hencodeview.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.quyunshuo.hencodeview.R
import com.quyunshuo.hencodeview.utils.px

private val IMAGE_WIDTH = 200f.px
private val IMAGE_PADDING = 0f.px
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

/**
 * 圆形头像
 *
 * @author Qu Yunshuo
 * @since 2/28/21 4:32 PM
 */
class AvatarView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = canvas.saveLayer(bounds, null)
        canvas.drawOval(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH, paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), IMAGE_PADDING, IMAGE_PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        // 设置仅加载bitmap信息
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)

        // 重置
        options.inJustDecodeBounds = false
        // 像素密度
        options.inDensity = options.outWidth
        // 该位图将被绘制到的目标像素密度
        options.inTargetDensity = width
        return  BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
    }
}