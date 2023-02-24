package com.banana.reader.navigation

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.banana.reader.databinding.NavigationBarBinding
import com.banana.reader.databinding.ScrollBarBinding

class NavigationBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var mBinding: NavigationBarBinding

    fun setupView(parent: ConstraintLayout) {
        mBinding = NavigationBarBinding.bind(parent)
    }
}