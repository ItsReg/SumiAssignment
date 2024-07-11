package com.example.sumiassignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        getAllData()
    }

    private fun getAllData() {
        RetrofitInstance.getInstance().create(ApiService::class.java).getAllData()
            .enqueue(object : Callback<List<ImageData>> {
                override fun onResponse(
                    call: Call<List<ImageData>>,
                    response: Response<List<ImageData>>
                ) {
                    if (response.isSuccessful) {
                        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
                            myAdapter = MyAdapter(response.body()!!) {
                                handleOnClick(it)
                            }
                            layoutManager = manager
                            adapter = myAdapter
                        }
                    }

                }

                override fun onFailure(call: Call<List<ImageData>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

    private fun handleOnClick(imageData: ImageData) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("title", imageData.title)
        intent.putExtra("albumid", imageData.url)
        intent.putExtra("imageurl", imageData.url)
        startActivity(intent)
    }
}