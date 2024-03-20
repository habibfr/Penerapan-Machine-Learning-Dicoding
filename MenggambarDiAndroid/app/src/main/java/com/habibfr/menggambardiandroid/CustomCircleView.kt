package com.habibfr.menggambardiandroid

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomCircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    val bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)
    val paint = Paint()

    init {
        paint.color = Color.GREEN
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(bitmap.width, bitmap.height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle((bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat(), 200f, paint)
    }
}

