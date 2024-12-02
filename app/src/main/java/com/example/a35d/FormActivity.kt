package com.example.a35d

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class FormActivity : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var button : Button
    lateinit var display : TextView

    lateinit var toast : Button
    lateinit var snack : Button
    lateinit var dialog : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)

        name = findViewById(R.id.editName)
        button = findViewById(R.id.btnSubmit)
        display = findViewById(R.id.display)


        button.setOnClickListener {
            val data : String = name.text.toString()

            display.text = data
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}