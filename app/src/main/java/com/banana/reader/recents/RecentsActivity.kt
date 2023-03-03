package com.banana.reader.recents

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RecentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mManager = supportFragmentManager
        var mTransaction = mManager.beginTransaction()
        var mFragment = RecentsFragment()

        mTransaction.replace(R.id.content, mFragment)
        mTransaction.addToBackStack(null)
        mTransaction.commit()
    }
}