package com.example.tony.eyezon.mvp.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.tony.eyezon.EyezonApplication
import com.example.tony.eyezon.PinService
import com.example.tony.eyezon.R
import com.example.tony.eyezon.mvp.model.Pins
import com.example.tony.eyezon.mvp.model.Request
import com.example.tony.eyezon.mvp.view.GoogleMapsView
import com.example.tony.eyezon.ui.GoogleMapsActivity
import io.reactivex.Observer
import javax.inject.Inject
import io.reactivex.disposables.Disposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Tony on 19.04.2018.
 */
@InjectViewState
class GoogleMapPresenter : MvpPresenter<GoogleMapsView> {

    @Inject
    lateinit  var mPinService: PinService


    var googleMapsActivity: GoogleMapsActivity? = null


    constructor(googleMapsActivity: GoogleMapsActivity?) {
        this.googleMapsActivity = googleMapsActivity
        EyezonApplication.graph.injectGoogleMapPresenter(this);
    }

    fun getPins() {


        /*

         observable?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe ({
                    result ->
                    Log.d("Result", "There are ${result.requests?.size} Java developers in Lagos")
                }, { error ->
                    Log.d("response","Ошибка")
                })
         */


        val observable = mPinService?.getPinsFromService("Bearer token")

        observable?.subscribeOn(Schedulers.computation())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : Observer<Pins> {

                    override fun onNext(t: Pins) {
                        Log.d("response", t.requests?.get(0)?.message)
                        googleMapsActivity?.setPinsInActivity(t)
                    }

                    override fun onComplete() {
                        Log.d("response","Все ок" )

                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.d("response","Отписка" )

                    }

                    override fun onError(e: Throwable) {
                        Log.d("response","Ошибка" )

                    }




                })
    }
}
