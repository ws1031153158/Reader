package com.banana.reader.search

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.banana.reader.Launcher
import com.banana.reader.databinding.SearchBarBinding

class SearchBar(context: Context) {

    var mLauncher = context as Launcher

    private var mButton = Button(context)
    private lateinit var mBinding: SearchBarBinding

    fun setupView(parent: ConstraintLayout) {
        mBinding = SearchBarBinding.bind(parent)
        mButton = mBinding.searchButton
        mButton.setOnClickListener {

        }
    }

    fun searchByBrowser() {
        var intent = Intent()
        intent.data = Uri.parse("www.google.com")
        mLauncher.startActivity(intent)
    }
}