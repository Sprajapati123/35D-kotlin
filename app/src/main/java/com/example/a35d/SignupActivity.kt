package com.example.a35d

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class SignupActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var date: EditText
    var countries = arrayOf(
        "Nepal", "China", "Bhutan", "Pakistan",
        "Canada", "Australia", "India"
    )

    var cities = arrayOf("Kathmandu", "Bhaktapur",
        "Lalitpur", "kritipur","kanchanpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.displaySpinner)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        date = findViewById(R.id.editTextDate)

        date.isClickable = true
        date.isFocusable = false
        date.setOnClickListener {
            loadCalendar()
        }

        val autoAdapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,
            cities
        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold = 2

        val adapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,
            countries
        )


        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )

        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SignupActivity,
            DatePickerDialog.OnDateSetListener
            { datePicker, year, month, day ->
                        //2023   5    10
                date.setText("$year/${month+1}/$day")
            },year,month,day
        )
        dialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        if (parent != null) {
            textView.text =
                parent.getItemAtPosition(position).toString()

        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}