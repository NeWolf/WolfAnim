package com.ewolf.wolfanimdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "WolfMainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        rvList.layoutManager = GridLayoutManager(applicationContext, 3)
        val data = ArrayList<String>()

        for (index in 1..9){
            data.add("$index")
        }

        rvList.adapter = NineAdapter(this, data)
    }


}