package com.example.assessment

import Data
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessment.retrofit.ApiInterface
import com.example.assessment.retrofit.RetrofitClient
import com.example.assessment.utils.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GifViewModel : ViewModel() {

    private var responseDataMutableLiveData: MutableLiveData<Data>? = null
    private var apiInterface: ApiInterface? = null
    private var call: Call<Data>? = null

    init {
        responseDataMutableLiveData = MutableLiveData()
        apiInterface = RetrofitClient.build()
        call = apiInterface!!.getGif(API_KEY, 25)
        loadGIF()
    }

    fun getResponseDataMutableLiveData(): MutableLiveData<Data>? {
        return responseDataMutableLiveData
    }

    fun loadGIF() {
        call?.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    if(response.body() != null) {
                        responseDataMutableLiveData?.value = response.body()
                    }
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }
}