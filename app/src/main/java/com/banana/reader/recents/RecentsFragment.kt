package com.banana.reader.recents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.banana.reader.FocusedItemDecorator
import com.banana.reader.GridViewAdapter
import com.banana.reader.databinding.GridViewBinding

class RecentsFragment : Fragment() {

    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: GridViewAdapter
    lateinit var mModel: RecentsModel

    private lateinit var mBinding: GridViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mModel = ViewModelProvider(this)[RecentsModel::class.java]

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = GridViewBinding.inflate(layoutInflater)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = mBinding.recents

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = mAdapter.getLayoutManager()
        mRecyclerView.addItemDecoration(FocusedItemDecorator(mRecyclerView))
    }
}