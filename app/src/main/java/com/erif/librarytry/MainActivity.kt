package com.erif.librarytry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erif.librarytry.detail.ActLib2
import com.erif.librarytry.detail.ActMenuItem
import com.erif.librarytry.list.AdapterList
import com.erif.librarytry.list.CallbackList
import com.erif.librarytry.list.ListHelper

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterList
    private lateinit var recyclerView: RecyclerView
    private lateinit var list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setupList()
        adapter.onItemClick(object : CallbackList {
            override fun onItemClick(position: Int) {
                val destination = getDetail(position)
                val title = list[position]
                intent(title, destination)
            }
        })
    }

    private fun initView() {
        adapter = AdapterList()
        recyclerView = findViewById(R.id.main_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupList() {
        list = ArrayList()
        val mList = listOf(
            "Menu Item", "Library 2"
        )
        for (item: String in mList) {
            list.add(item)
        }
        adapter.setList(list)
    }

    private fun intent(title: String, destination: Class<*>) {
        val intent = Intent(this, destination)
        intent.putExtra("title", title)
        startActivity(intent)
    }

    private fun getDetail(position: Int): Class<*> {
        return when(position) {
            ListHelper.LIB_MENU_ITEM -> {
                ActMenuItem::class.java
            }
            else -> {
                ActLib2::class.java
            }
        }
    }

}