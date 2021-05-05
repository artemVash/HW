package by.vashkevich.lesson1hw

import HW5.HomeWork5ViewModel
import HW5.UserPageActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.accept
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
const val TAG = "get name"

class HomeWork5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work5)

        val nameUser = findViewById<TextInputEditText>(R.id.input_email)
        val password = findViewById<TextInputEditText>(R.id.input_password)
        val btnRegister = findViewById<Button>(R.id.button_register)

        val nameLayout = findViewById<TextInputLayout>(R.id.name_layout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.password_layout)

        btnRegister.setOnClickListener {

            if (nameUser.text.isNullOrEmpty()) {
                nameLayout.error = "Поле пустое"
                return@setOnClickListener
            }else{

                nameLayout.error = null
            }

            if (password.text.isNullOrEmpty()) {
                passwordLayout.error = "Поле пустое"
                return@setOnClickListener
            }else{
                passwordLayout.error = null
            }

            if (password.text.toString().length < 8) {
                passwordLayout.error = "Пароль меньше 8 символов"
                return@setOnClickListener
            }else{
                passwordLayout.error = null
            }

            MaterialAlertDialogBuilder(this)
                    .setTitle(resources.getString(R.string.title))
                    .setIcon(R.drawable.done)
                    .setNegativeButton(resources.getString(R.string.ok)) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(resources.getString(R.string.sing_in)) { dialog, which ->
                        val intent = Intent(this,UserPageActivity::class.java)
                        intent.putExtra(TAG,nameUser.text.toString())
                        startActivity(intent)
                    }
                    .show()


        }
    }
}