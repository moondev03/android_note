package com.example.immortalservice

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class ImmortalService : Service() {

    companion object {
        const val TAG = "ImmortalService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "ImmortalService onCreate()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "ImmortalService onStartCommand()")

        val notification = createNotification()
        startForeground(1, notification)

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ImmortalService onDestroy()")
    }

    private fun createNotification(): Notification {
        val channelId = "my_channel_id"
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
        notificationBuilder
            .setContentTitle("서비스가 실행 중입니다")
            .setContentText("서비스가 백그라운드에서 계속 실행 중입니다.")
            .setSmallIcon(R.mipmap.ic_launcher)

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        notificationBuilder.setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "My Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        return notificationBuilder.build()
    }

}
