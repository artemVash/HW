package by.vashkevich.lesson1hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonTextView1 = findViewById<TextView>(R.id.tv_dz1)
        val buttonTextView2 = findViewById<TextView>(R.id.tv_dz2)

        buttonTextView1.setOnClickListener {
            val intent = Intent(this,HomeWork1Activity::class.java)
            startActivity(intent)
        }
    }
}