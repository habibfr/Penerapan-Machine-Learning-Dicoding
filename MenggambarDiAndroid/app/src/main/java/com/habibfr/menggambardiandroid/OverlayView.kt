package com.habibfr.menggambardiandroid

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class OverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Di sini Anda bisa langsung menggunakan canvas dari kelas View.
    }
}