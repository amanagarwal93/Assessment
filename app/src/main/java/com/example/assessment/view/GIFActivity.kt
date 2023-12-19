package com.example.assessment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment.GifFragment
import com.example.assessment.R

class GIFActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif)

        val gifFragment = GifFragment()
        val url = intent?.getStringExtra("imageUrl")

        val bundle = Bundle()
        bundle.putString("imageUrl", url)
        gifFragment.arguments = bundle

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, gifFragment, "ImageFragment")
                .commit()
        }
    }
}
