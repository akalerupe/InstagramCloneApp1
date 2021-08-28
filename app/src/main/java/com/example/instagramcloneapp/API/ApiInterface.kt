package com.example.instagramcloneapp.API

import com.example.instagramcloneapp.Models.Photos
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    fun fetchPhotos():Call<List<Photos>>
}