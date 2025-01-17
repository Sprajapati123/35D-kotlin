package com.example.a35d

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a35d.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user",
                                                Context.MODE_PRIVATE)



        binding.btnLogin.setOnClickListener {
            val username : String = binding.editUsername.text.toString()
            val password : String = binding.editPassword.text.toString()

            if(username.isEmpty()){
                binding.editUsername.error = "username can't be empty"
            }else if(password.isEmpty()){
                binding.editPassword.error = "password can't be empty"
            }else{
                if(binding.rememberMe.isChecked){
                    val editor = sharedPreferences.edit()

                    editor.putString("username",username)
                    editor.putString("password",password)


                    editor.apply()
                }
                val intent = Intent(
                    this@LoginActivity,
                    DestinationActivity::class.java
                )
                intent.putExtra("ndjibadka",username)
                intent.putExtra("password",password)

                startActivity(intent)
                finish()
            }


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}