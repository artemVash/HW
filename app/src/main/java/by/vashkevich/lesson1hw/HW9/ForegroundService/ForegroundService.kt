package by.vashkevich.lesson1hw.HW9.ForegroundService

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import by.vashkevich.lesson1hw.HW9.ViewModelHW9
import by.vashkevich.lesson1hw.HW9.data.entities.Advice
import by.vashkevich.lesson1hw.HW9.receiver.MyBroadcastReceiver
import by.vashkevich.lesson1hw.HomeWork9Activity
import by.vashkevich.lesson1hw.R

class ForegroundService : Service(){


    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val ad = intent?.getStringExtra("ad")


        val contentIntent = PendingIntent.getActivity(
            this,
            12,
            Intent(this,HomeWork9Activity::class.java),
            PendingIntent.FLAG_CANCEL_CURRENT)

        val intent = Intent().apply {
            action = HomeWork9Activity.BROADCAST_ACTION
            putExtra(MyBroadcastReceiver.BROADCAST,ad)
        }

        val actionIntent = PendingIntent.getBroadcast(
            this,
            7,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        val notification = NotificationCompat.Builder(this,App.NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Massage")
            .setContentText("time is over")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(contentIntent)
            .setPriority(2)
            .addAction(
                R.drawable.ic_notification,
                "advice",
                actionIntent
            )
            .setAutoCancel(true)
            .build()

        startForeground(1,notification)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


}