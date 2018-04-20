package com.example.tony.eyezon.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName




class User {
    @SerializedName("userId")
    val userId: String? = null
    @SerializedName("rating")
    val rating: Int? = null
    @SerializedName("firstName")
    val firstName: String? = null
    @SerializedName("lastName")
    val lastName: String? = null
    @SerializedName("photo")
    val photo: String? = null
    @SerializedName("nickName")
    val nickName: String? = null
}