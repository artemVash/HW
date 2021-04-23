
package HW5

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.vashkevich.lesson1hw.R

const val TAG = "get name"

class UserPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)

        val textNameUser = findViewById<TextView>(R.id.text_name_user)

        textNameUser.text = intent.getStringExtra(TAG)
    }
}