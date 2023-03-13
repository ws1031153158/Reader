package com.banana.reader

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LauncherModel : ViewModel() {
    val itemCount = MutableLiveData<Int>()

    init {
        itemCount
    }

    fun updateItemInDb(context: Context, id: Long, contentValues: ContentValues) {
        val resolver = LauncherResolver(context)
        val uri = getContentUri(id)
        val runnable = Runnable {
            if (uri != null) {
                resolver.update(uri, contentValues, null, null)
            }
        }
    }

    private fun getContentUri(id : Long): Uri? {
        return Uri.parse(Constants.CONTENT_URI_STRING + "/" + id)
    }

    class ModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LauncherModel() as T
        }
    }
}