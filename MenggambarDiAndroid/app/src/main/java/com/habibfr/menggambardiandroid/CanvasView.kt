package com.habibfr.menggambardiandroid

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat

class CanvasView : View {
    constructor(
        context: Context
    ) : super(context) {
    }

    constructor(
        context: Context, attrs: AttributeSet
    ) : super(context, attrs) {
    }

    constructor(
        context: Context, attrs: AttributeSet, defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Di sini Anda bisa langsung menggunakan canvas dari kelas View.
    }

}