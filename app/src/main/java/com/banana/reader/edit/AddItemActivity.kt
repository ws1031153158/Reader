package com.banana.reader.edit

import android.os.Bundle
import com.banana.reader.BaseActivity

class AddItemActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extra = intent.getStringExtra("event_source")
    }
}