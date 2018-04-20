package com.example.tony.eyezon

import com.example.tony.eyezon.mvp.model.Pins
import com.example.tony.eyezon.network.PinApi
import io.reactivex.Observable

/**
 * Created by Tony on 15.04.2018.
 */
class PinService(var pinApi: PinApi) {


    fun getPinsFromService(token:String) : Observable<Pins>? {
        return pinApi?.getPinsFromServer(token);
    }
}