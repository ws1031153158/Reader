package com.banana.reader.analyze

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.banana.reader.Application

object ParserHelper {

    fun notifyComplete(context: Context, id: String) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = PendingIntent.getActivity(Application.getInstance(), 0, Intent(), 0)
        val notification  = NotificationCompat.Builder(context, id)
            .setContentText("parse complete")
            .setContentIntent(intent)
            .setAutoCancel(true)
            .build()
        manager.notify(0, notification)
    }
}