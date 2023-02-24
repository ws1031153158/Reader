package com.banana.reader.indicator

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.banana.reader.databinding.IndicatorBarBinding

class IndicatorBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var mBinding: IndicatorBarBinding

    fun setupView(parent: ConstraintLayout) {
        mBinding = IndicatorBarBinding.bind(parent)
    }
}