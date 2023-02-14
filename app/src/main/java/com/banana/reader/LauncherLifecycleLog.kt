package com.banana.reader

import android.util.Log

class LauncherLifecycleLog(launcher: Launcher) {
    companion object {
        private const val TAG = "Launcher.Lifecycle"
    }

    private val mLauncher = launcher

    fun onCreate() {
        Log.d(TAG, "onCreate: " + mLauncher.getLauncherInfo())
    }

    fun onStart() {
        Log.d(TAG, "onStart: " + mLauncher.getLauncherInfo())
    }

    fun onResume() {
        Log.d(TAG, "onResume: " + mLauncher.getLauncherInfo())
    }

    fun onPause() {
        Log.d(TAG, "onPause: " + mLauncher.getLauncherInfo())
    }

    fun onDestroy() {
        Log.d(TAG, "onDestroy: " + mLauncher.getLauncherInfo())
    }

    fun onWindowFocusChanged() {
        Log.d(TAG, "onWindowFocusChanged: " + mLauncher.getLauncherInfo())
    }
}