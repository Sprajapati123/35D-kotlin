package com.example.a35d

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.a35d.databinding.ActivityCheckBinding

class CheckActivity : AppCompatActivity() {
    lateinit var checkBinding: ActivityCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        checkBinding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(checkBinding.root)

        replaceFragment(FirstFragment())

        checkBinding.btnFirstButton.setOnClickListener {
            replaceFragment(FirstFragment())
        }
        checkBinding.btnSecondButton.setOnClickListener {
        replaceFragment(SecondFragment())
        }


        ViewCompat.setOnApplyWindowInsetsListener(checkBinding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout,fragment)

        fragmentTransaction.commit()

    }
}