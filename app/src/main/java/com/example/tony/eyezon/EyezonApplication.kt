package com.example.tony.eyezon

import android.app.Application
import com.example.tony.eyezon.di.AppComponent
import com.example.tony.eyezon.di.DaggerAppComponent
import com.example.tony.eyezon.di.modules.ContextModule


/**
 * Created by Tony on 15.04.2018.
 */

class EyezonApplication: Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: AppComponent
    }





    override fun onCreate() {
        super.onCreate()
        graph =  DaggerAppComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()
        graph.injectGoogleMapPresenter(this)
    }



}
