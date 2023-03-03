package com.banana.reader.settings

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.banana.reader.BaseActivity

class ReaderSettings : BaseActivity(){
    private lateinit var mModel: SettingsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mModel = ViewModelProvider(this)[SettingsModel::class.java]

        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}