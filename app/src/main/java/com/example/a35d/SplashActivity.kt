package com.example.a35d

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        sharedPreferences = getSharedPreferences("user",
            Context.MODE_PRIVATE)

        val username : String = sharedPreferences.getString("username","").toString()
        val password : String = sharedPreferences.getString("password","").toString()

        Handler(Looper.getMainLooper()).postDelayed({
            if(username.isEmpty()){
                val intent = Intent(this@SplashActivity,
                    LoginActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this@SplashActivity,
                    DestinationActivity::class.java)
                startActivity(intent)
            }

        },3000)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


