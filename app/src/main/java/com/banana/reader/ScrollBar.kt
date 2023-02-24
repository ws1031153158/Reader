package com.banana.reader

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.banana.reader.databinding.ScrollBarBinding
import com.banana.reader.databinding.SearchBarBinding

class ScrollBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private lateinit var mRecyclerView: BaseRecyclerView
    private lateinit var mScrollListener: RecyclerView.OnScrollListener

    private lateinit var mBinding: ScrollBarBinding

    fun setRecyclerView(recyclerView: RecyclerView) {
        if (mRecyclerView != null && mScrollListener != null) {
            mRecyclerView.removeOnScrollListener(mScrollListener)
        }
        mRecyclerView = recyclerView as BaseRecyclerView
        mScrollListener = object : BaseScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (visibility != VISIBLE) {
                    return
                }
                mRecyclerView.onUpdateScrollbar(dy)
            }
        }
        mRecyclerView.addOnScrollListener(mScrollListener)
    }

    fun setupView(parent: ConstraintLayout) {
        mBinding = ScrollBarBinding.bind(parent)
    }
}