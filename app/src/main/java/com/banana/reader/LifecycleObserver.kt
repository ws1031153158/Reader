package com.banana.reader

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleObserver(launcher: Launcher) : LifecycleEventObserver {
    companion object {
        private const val TAG = "Launcher.Lifecycle"
    }

    private val mLauncher = launcher

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d(TAG, "onCreate: " + mLauncher.getLauncherInfo())
            }
            Lifecycle.Event.ON_START -> {
                Log.d(TAG, "onStart: " + mLauncher.getLauncherInfo())
            }
            Lifecycle.Event.ON_RESUME -> {
                Log.d(TAG, "onResume: " + mLauncher.getLauncherInfo())
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d(TAG, "onPause: " + mLauncher.getLauncherInfo())
            }
            Lifecycle.Event.ON_STOP -> {
                Log.d(TAG, "onStop: " + mLauncher.getLauncherInfo())
            }
            Lifecycle.Event.ON_DESTROY -> {
                Log.d(TAG, "onDestroy: " + mLauncher.getLauncherInfo())
            }
            else -> {}
        }
    }
}