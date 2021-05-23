package by.vashkevich.lesson1hw

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import by.vashkevich.lesson1hw.HW9.ForegroundService.ForegroundService
import by.vashkevich.lesson1hw.HW9.ViewModelHW9
import by.vashkevich.lesson1hw.HW9.data.entities.Advice
import by.vashkevich.lesson1hw.HW9.receiver.MyBroadcastReceiver

class HomeWork9Activity : AppCompatActivity() {

    private val viewModel by lazy{
        ViewModelProvider(this).get(ViewModelHW9::class.java)
    }

    companion object{
        const val BROADCAST_ACTION = "action"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work9)


        val mReceiver = MyBroadcastReceiver()

        val intentFilter = IntentFilter().apply {
            addAction(BROADCAST_ACTION)
        }
        registerReceiver(mReceiver,intentFilter)

        val textTimer = findViewById<TextView>(R.id.text_test)
        val btn = findViewById<Button>(R.id.btn_advice)

        viewModel.timer.observe(this){

            textTimer.text = it.toString()
            if(it == 0){
                val intent = Intent(this,ForegroundService::class.java).putExtra("ad",viewModel.advice.value?.advice)
                startService(intent)
            }
        }


        btn.setOnClickListener {
            viewModel.startTimer()
            viewModel.loadAdvice()

        }
    }
}