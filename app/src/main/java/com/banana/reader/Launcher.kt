package com.banana.reader

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ActivityInfo.CONFIG_ORIENTATION
import android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.banana.reader.broadcast.ScreenChangedBroadcastReceiver
import com.banana.reader.databinding.*
import com.banana.reader.edit.AddItemActivity
import com.banana.reader.indicator.IndicatorBar
import com.banana.reader.navigation.NavigationBar
import com.banana.reader.search.SearchBar

class Launcher : BaseActivity() {

    companion object {
        const val TAG = "Launcher"
    }

    private lateinit var mObserver: LifecycleObserver
    private lateinit var mOldConfig: Configuration

    private lateinit var mModel: LauncherModel
    private lateinit var mScrollBar: ScrollBar
    private lateinit var mIndicatorBar: IndicatorBar
    private lateinit var mNavigationBar: NavigationBar
    private lateinit var mSearchBar: SearchBar
    private lateinit var mLauncherViewBinding : LauncherBinding

    private lateinit var mBroadcastReceiver: ScreenChangedBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        mOldConfig = Configuration(resources.configuration)
        mObserver = LifecycleObserver(this)
        mModel = ViewModelProvider(this, LauncherModel.ModelFactory())[LauncherModel::class.java]
        mBroadcastReceiver = ScreenChangedBroadcastReceiver()

        super.onCreate(savedInstanceState)

        observeModel()
        lifecycle.addObserver(mObserver)
        registerReceiver()
        setupViews()
    }

    private fun observeModel() {
        mModel.itemCount.observe(this, Observer { count ->
            count
        })
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

    private fun registerReceiver() {
        registerReceiver(mBroadcastReceiver, IntentFilter(Constants.SYSTEM_SCREEN_ON))
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

        unregisterReceiver()
        super.onDestroy()
    }

    private fun unregisterReceiver() {
        unregisterReceiver(mBroadcastReceiver)
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

    fun notifyMessageUpdate() {
        var intent = Intent()
        intent.action = Intent.ACTION_PACKAGE_CHANGED
        sendBroadcast(intent)
    }
}