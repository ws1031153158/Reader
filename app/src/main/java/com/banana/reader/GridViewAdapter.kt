package com.banana.reader

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GridViewAdapter : RecyclerView.Adapter<GridViewAdapter.ViewHolder>() {
    lateinit var mGridLayoutManager: GridLayoutManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class GridLayoutManager(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : androidx.recyclerview.widget.GridLayoutManager(context, attrs, defStyleAttr, defStyleRes) {

    }

    fun getLayoutManager(): GridLayoutManager {
        return mGridLayoutManager
    }
}