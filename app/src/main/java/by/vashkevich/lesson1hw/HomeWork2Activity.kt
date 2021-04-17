package by.vashkevich.lesson1hw

import HW2.AnimationActivity
import HW2.FlagActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeWork2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work2)

        val buttonFlag = findViewById<TextView>(R.id.button_flag)
        val buttonAnimation = findViewById<TextView>(R.id.button_animation)
        val buttonBack = findViewById<TextView>(R.id.btn_back_hw2)

        buttonFlag.setOnClickListener {
            val intent = Intent(this,FlagActivity::class.java)
            startActivity(intent)
        }

        buttonAnimation.setOnClickListener {
            val intent = Intent(this,AnimationActivity::class.java)
            startActivity(intent)
        }
        buttonBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}