package com.example.tony.eyezon.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Tony on 15.04.2018.
 */

class Pins{
    @SerializedName("requests")
    var requests: ArrayList<Request>? = null
    @SerializedName("count")
    var count: Int? = null
}
