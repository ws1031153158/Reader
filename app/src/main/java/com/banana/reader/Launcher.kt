package com.banana.reader

import android.content.pm.ActivityInfo.CONFIG_ORIENTATION
import android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import com.banana.reader.indicator.IndicatorBar
import com.banana.reader.navigation.NavigationBar

class Launcher : BaseActivity() {

    companion object {
        const val TAG = "Launcher"
    }

    private lateinit var mLifecycleLog: LauncherLifecycleLog
    private lateinit var mOldConfig: Configuration

    private lateinit var mScrollBar: ScrollBar
    private lateinit var mIndicatorBar: IndicatorBar
    private lateinit var mNavigationBar: NavigationBar

    override fun onCreate(savedInstanceState: Bundle?) {
        mLifecycleLog = LauncherLifecycleLog(this)
        mOldConfig = Configuration(resources.configuration)
        mLifecycleLog.onCreate()
        setupViews()
        super.onCreate(savedInstanceState)
    }

    private fun setupViews() {
        mScrollBar.setupView()
        mIndicatorBar.setupView()
        mNavigationBar.setupView()
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
        Log.d(TAG, "onConfigurationChange: $this")
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

    private fun onOrientationChanged() {
        Log.d(TAG, "onOrientationChanged: ")
    }

    fun getLauncherInfo() {
        Log.d(TAG, hashCode().toString() + " " + hasWindowFocus())
    }
}