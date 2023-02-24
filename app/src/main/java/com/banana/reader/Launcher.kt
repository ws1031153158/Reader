package com.banana.reader

import android.content.Intent
import android.content.pm.ActivityInfo.CONFIG_ORIENTATION
import android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.banana.reader.databinding.*
import com.banana.reader.edit.AddItemActivity
import com.banana.reader.indicator.IndicatorBar
import com.banana.reader.navigation.NavigationBar
import com.banana.reader.search.SearchBar

class Launcher : BaseActivity() {

    companion object {
        const val TAG = "Launcher"
    }

    private lateinit var mLifecycleLog: LauncherLifecycleLog
    private lateinit var mOldConfig: Configuration

    private lateinit var mScrollBar: ScrollBar
    private lateinit var mIndicatorBar: IndicatorBar
    private lateinit var mNavigationBar: NavigationBar
    private lateinit var mSearchBar: SearchBar
    private lateinit var mLauncherViewBinding : LauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mLifecycleLog = LauncherLifecycleLog(this)
        mOldConfig = Configuration(resources.configuration)
        mLifecycleLog.onCreate()

        super.onCreate(savedInstanceState)

        setupViews()
    }

    private fun setupViews() {
        mLauncherViewBinding = LauncherBinding.inflate(layoutInflater)
        setContentView(mLauncherViewBinding.root)

        mScrollBar = ScrollBar(this)
        mIndicatorBar = IndicatorBar(this)
        mNavigationBar = NavigationBar(this)
        mSearchBar = SearchBar(this)

        mScrollBar.setupView(mLauncherViewBinding.root)
        mNavigationBar.setupView(mLauncherViewBinding.root)
        mIndicatorBar.setupView(mLauncherViewBinding.root)
        mSearchBar.setupView(mLauncherViewBinding.root)
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

    fun startAddActivity() {
        var requestData = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data?.getStringExtra("result")
            }
        }
        var intent = Intent(this, AddItemActivity::class.java)
        intent.putExtra("event_source", "com.banana.reader")
        requestData.launch(intent)
    }

    fun startSettingActivity() {
        var intent = Intent()
        intent.action = Intent.ACTION_EDIT
        intent.addCategory(Intent.CATEGORY_TAB)
        startActivity(intent)
    }
}