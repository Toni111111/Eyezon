package com.example.tony.eyezon.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Tony on 15.04.2018.
 */
class Request {
    @SerializedName("_id")
    val id: String? = null
    @SerializedName("message")
    val message: String? = null
    @SerializedName("place")
    val place: String? = null
    @SerializedName("description")
    val description: String? = null
    @SerializedName("userId")
    val userId: String? = null
    @SerializedName("hash")
    val hash: String? = null
    @SerializedName("notified")
    val notified: List<String>? = null
    @SerializedName("closed")
    val closed: Boolean? = null
    @SerializedName("answered")
    val answered: Boolean? = null
    @SerializedName("timeToStayAlive")
    val timeToStayAlive: Int? = null
    @SerializedName("time")
    val time: String? = null
    @SerializedName("position")
    val position: Position? = null
    @SerializedName("type")
    val type: String? = null
    @SerializedName("distance")
    val distance: Double? = null
    @SerializedName("user")
    val user: User? = null
    @SerializedName("answersCount")
    val answersCount: Int? = null
    @SerializedName("timeRaw")
    val timeRaw: String? = null
    @SerializedName("placeId")
    val placeId: String? = null
}