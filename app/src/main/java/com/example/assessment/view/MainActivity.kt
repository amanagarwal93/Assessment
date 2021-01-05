package com.example.assessment.view

import Data
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assessment.GifViewModel
import com.example.assessment.utils.ItemClickListener
import com.example.assessment.R
import com.example.assessment.adapter.GIFAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListener {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var viewModel: GifViewModel
    private lateinit var adapter: GIFAdapter
    private var recyclerDataArrayList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerDataArrayList = ArrayList()

        viewModel = ViewModelProvider(
            this
        ).get(GifViewModel::class.java)

        setupUI()
    }

    private fun setupUI() {
        recycler_view.setHasFixedSize(true)
        recycler_view.setItemViewCacheSize(30)
        recycler_view.layoutManager = GridLayoutManager(this, 3)
        viewModel.getResponseDataMutableLiveData()?.observe(this, Observer {
            Log.d(TAG, "data updated $it")
            if(it  != null) {
                for (url in it.bitly_gif_url) {
                    recyclerDataArrayList?.add(url.toString())
                }
            }
            adapter =
                recyclerDataArrayList?.let { it1 -> GIFAdapter(it1, this) }!!
            recycler_view.adapter = adapter
        })
        //        recycler_view.isDrawingCacheEnabled = true
//        recycler_view.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH


    }

    override fun itemClick(url: String) {
        val intentData = Intent(this, GIFActivity::class.java)
        intentData.putExtra("imageUrl", url)
        startActivity(intentData)
    }
}