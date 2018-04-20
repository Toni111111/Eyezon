package com.example.tony.eyezon.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Tony on 15.04.2018.
 */
class Position {
    @SerializedName("coordinates")
    val coordinates: List<List<List<String>>>? = null
    @SerializedName("type")
     val type: String? = null
}