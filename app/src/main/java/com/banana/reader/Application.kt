package com.banana.reader

import android.content.Context

class Application : android.app.Application() {

    companion object{
        private val sInstance: Application by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Application()
        }

        fun getInstance(): Application {
            return sInstance
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}