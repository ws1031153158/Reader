package com.banana.reader

import android.os.Bundle
import android.util.Log

class Launcher : BaseActivity() {

    companion object {
        const val TAG = "Launcher"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Launcher onCreate")
        super.onCreate(savedInstanceState)
    }
}