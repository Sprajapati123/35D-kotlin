package com.example.a35d

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a35d.adapter.FruitsAdapter

class FruitsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var imageList = ArrayList<Int>()
    var titleList = ArrayList<String>()
    var descList = ArrayList<String>()

    lateinit var fruitsAdapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruits)
        recyclerView = findViewById(R.id.recyclerView)

        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.grapes)
        imageList.add(R.drawable.mango)

        titleList.add("Apple")
        titleList.add("Grapes")
        titleList.add("Mango")

        descList.add("This is apple")
        descList.add("This is grapes")
        descList.add("This is mango")


        fruitsAdapter = FruitsAdapter(
            this@FruitsActivity,
            imageList, titleList, descList
        )

        recyclerView.adapter =  fruitsAdapter

        recyclerView.layoutManager = LinearLayoutManager(
            this@FruitsActivity,
            LinearLayoutManager.HORIZONTAL,
            false)

//        recyclerView.layoutManager = GridLayoutManager(
//            this@FruitsActivity,
//            2
//        )



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}