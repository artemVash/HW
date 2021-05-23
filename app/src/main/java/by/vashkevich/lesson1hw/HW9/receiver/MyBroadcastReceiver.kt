package by.vashkevich.lesson1hw.HW9.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MyBroadcastReceiver : BroadcastReceiver() {

    companion object{
        const val BROADCAST = "broadcast"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,intent?.getStringExtra(BROADCAST).orEmpty(),Toast.LENGTH_SHORT).show()
    }
}