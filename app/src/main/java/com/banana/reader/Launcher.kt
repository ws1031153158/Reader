package com.banana.reader

import android.content.Context
import android.content.pm.ActivityInfo.CONFIG_ORIENTATION
import android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

class Launcher(context: Context) : BaseActivity() {

    companion object {
        const val TAG = "Launcher"
    }

    private val mContext = context
    private lateinit var mLifecycleLog : LauncherLifecycleLog
    private lateinit var mOldConfig : Configuration

    override fun onCreate(savedInstanceState: Bundle?) {
        mLifecycleLog = LauncherLifecycleLog(this)
        mLifecycleLog.onCreate()
        mOldConfig = Configuration(resources.configuration)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        mLifecycleLog.onStart()
        super.onStart()
    }

    override fun onResume() {
        mLifecycleLog.onResume()
        super.onResume()
    }

    override fun onPause() {
        mLifecycleLog.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mLifecycleLog.onDestroy()
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.d(TAG, "onConfigurationChange: $mContext")
        var diff : Int = newConfig.diff(mOldConfig)
        if ((diff and (CONFIG_ORIENTATION or CONFIG_SCREEN_SIZE)) != 0) {
            onOrientationChanged()
        }
        super.onConfigurationChanged(newConfig)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        mLifecycleLog.onWindowFocusChanged()
        super.onWindowFocusChanged(hasFocus)
    }

    fun onOrientationChanged() {
        Log.d(TAG, "onOrientationChanged: ")
    }

    fun getLauncherInfo() {
        Log.d(TAG, hashCode().toString() + " " + hasWindowFocus())
    }
}