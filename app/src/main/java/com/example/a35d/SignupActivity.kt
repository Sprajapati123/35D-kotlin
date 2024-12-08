
package com.example.a35d

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var textView: TextView

    var countries = arrayOf(
        "Nepal","China","Bhutan","Pakistan",
        "Canada","Australia","India"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.displaySpinner)

        val adapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,
            countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line)

        spinner.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}