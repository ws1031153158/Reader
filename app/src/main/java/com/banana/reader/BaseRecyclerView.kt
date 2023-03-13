package com.banana.reader

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {

    abstract fun onUpdateScrollbar(dy: Int)

    private fun bindScrollbar(requestLayout: Boolean) {

    }

    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
    }

    override fun onSizeChanged(width: Int, height: Int, lastWidth: Int, lastHeight: Int) {

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        bindScrollbar(false)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

    }
}