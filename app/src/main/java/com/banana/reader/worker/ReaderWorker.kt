package com.banana.reader.worker

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class ReaderWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    companion object{
        private const val TAG = "ReaderWork"
    }

    override fun doWork(): Result {
        Log.d(TAG,"ReaderWorker.doWork")
        return Result.success()
    }
}