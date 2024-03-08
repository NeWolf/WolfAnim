package com.newolf.animdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "WolfMainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uiOptions2 = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = uiOptions2

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