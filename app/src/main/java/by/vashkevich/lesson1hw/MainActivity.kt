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
        val buttonTextView3 = findViewById<TextView>(R.id.tv_dz3)
        val buttonTextView4 = findViewById<TextView>(R.id.tv_dz4)
        val buttonTextView5 = findViewById<TextView>(R.id.tv_dz5)
        val buttonTextView6 = findViewById<TextView>(R.id.tv_dz6)
        val buttonTextView7 = findViewById<TextView>(R.id.tv_dz7)
        val buttonTextView8 = findViewById<TextView>(R.id.tv_dz8)

        buttonTextView1.setOnClickListener {
            val intent = Intent(this,HomeWork1Activity::class.java)
            startActivity(intent)
        }

        buttonTextView2.setOnClickListener {
            val intent = Intent(this,HomeWork2Activity::class.java)
            startActivity(intent)
        }

        buttonTextView3.setOnClickListener {
            val intent = Intent(this,HomeWork3Activity::class.java)
            startActivity(intent)
        }

        buttonTextView4.setOnClickListener {
            val intent = Intent(this,HomeWork4Activity::class.java)
            startActivity(intent)
        }

        buttonTextView5.setOnClickListener {
            val intent = Intent(this,HomeWork5Activity::class.java)
            startActivity(intent)
        }

        buttonTextView6.setOnClickListener {
            val intent = Intent(this,HomeWork6Activity::class.java)
            startActivity(intent)
        }

        buttonTextView7.setOnClickListener {
            val intent = Intent(this,HomeWork7Activity::class.java)
            startActivity(intent)
        }

        buttonTextView8.setOnClickListener {
            val intent = Intent(this,HomeWork8Activity::class.java)
            startActivity(intent)
        }
    }
}