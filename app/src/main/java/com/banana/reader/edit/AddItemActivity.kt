package com.banana.reader.edit

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.banana.reader.BaseActivity

class AddItemActivity: BaseActivity() {
    private lateinit var mModel: AddItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mModel = ViewModelProvider(this)[AddItemModel::class.java]

        super.onCreate(savedInstanceState)

        val extra = intent.getStringExtra("event_source")
    }
}