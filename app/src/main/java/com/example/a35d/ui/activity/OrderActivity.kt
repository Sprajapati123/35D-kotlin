package com.example.a35d.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a35d.R
import com.example.a35d.adapter.TabAdapter
import com.example.a35d.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    override fun onPause() {
        Log.d("lifecycle","Onpause -> I am called")
        super.onPause()
    }

    override fun onResume() {
        Log.d("lifecycle","ONResume -> I am called")
        super.onResume()
    }

    override fun onStart() {
        Log.d("lifecycle","onStart -> I am called")
        super.onStart()
    }

    override fun onDestroy() {
        Log.d("lifecycle","OnDestroy -> I am called")
        super.onDestroy()
    }

    lateinit var binding: ActivityOrderBinding

    //if tab ko header ma icon rakne bhaye
    var icons = arrayOf(
        R.drawable.baseline_notifications_24,
        R.drawable.baseline_home_24,
        R.drawable.baseline_person_24,
    )
    //if tab ko header ma text rakne bhaye
    var data = arrayOf(
        "Active Order",
        "Cancelled Order",
        "Delivered Order",
    )

    lateinit var adapter: TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Log.d("lifecycle","onCreate -> I am called")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}