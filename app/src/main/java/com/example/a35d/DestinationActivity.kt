package com.example.a35d

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a35d.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {
    lateinit var binding : ActivityDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username : String =
            intent.getStringExtra("ndjibadka").toString()
        val password : String =
            intent.getStringExtra("password").toString()

        binding.outputUsername.text = username
        binding.outputPassword.text = password

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}