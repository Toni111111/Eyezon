package com.example.tony.eyezon.network

import com.example.tony.eyezon.mvp.model.Pins
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header


/**
 * Created by Tony on 15.04.2018.
 */

interface PinApi {

    @GET("/requests/52.0975500/23.6877500/10000000")
    fun getPinsFromServer(@Header("Authorization") token: String): Observable<Pins>
}
