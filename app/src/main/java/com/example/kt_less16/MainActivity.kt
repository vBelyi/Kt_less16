package com.example.kt_less16
import io.reactivex.rxkotlin.subscribeBy
import android.app.Activity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)


        val listView: RecyclerView = findViewById(R.id.listView)
        val api = ApiClient.client.create(ApiInterface::class.java)
        api.getRequest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response->
                       if (response.isNotEmpty()) {
                           val items = response
                           val myAdapter = MyRecyclerViewAdapter(items, {})
                           listView.adapter = myAdapter
                       }
            }, {error ->
                error.printStackTrace()
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            })
        val dividerItemDecoration = DividerItemDecoration(listView.context, LinearLayoutManager.VERTICAL)
        listView.addItemDecoration(dividerItemDecoration)
        listView.layoutManager = LinearLayoutManager(this)
    }
}

