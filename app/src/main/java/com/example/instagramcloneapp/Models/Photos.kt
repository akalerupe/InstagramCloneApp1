package com.example.instagramcloneapp.Models

import com.google.gson.annotations.SerializedName

data class Photos(
    val id:String,
    @SerializedName("image_url")
    val imageUrl:String,
    val caption:String,
)
