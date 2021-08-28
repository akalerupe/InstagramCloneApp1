package com.example.instagramcloneapp.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramcloneapp.API.ApiClient
import com.example.instagramcloneapp.API.ApiInterface
import com.example.instagramcloneapp.Models.Photos
import com.example.instagramcloneapp.R
import com.example.instagramcloneapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvphotos: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvphotos = findViewById(R.id.rvphotos)
        fetchPosts()
    }
    fun fetchPosts(){
        var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.fetchPhotos()
        request.enqueue(object : Callback<List<Photos>> {

            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                if(response.isSuccessful){
                    var photos=response.body()!!
                    rvphotos.layoutManager= LinearLayoutManager(baseContext)
                    var photosAdapter=PhotosAdapter(photos)
                    rvphotos.adapter=photosAdapter
                    Toast.makeText(baseContext, "${photos!!.size} photos", Toast.LENGTH_LONG).show()

                }
            }
            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }
        })

    }

}


