package com.example.tony.eyezon.di

import android.app.Application
import android.content.Context
import com.example.tony.eyezon.PinService
import com.example.tony.eyezon.di.modules.ContextModule
import com.example.tony.eyezon.di.modules.PinModule
import com.example.tony.eyezon.mvp.presenter.GoogleMapPresenter
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules =  arrayOf(ContextModule::class, PinModule::class))
public interface AppComponent {

    fun getContext(): Context
    fun getAuthService() : PinService

    fun injectGoogleMapPresenter(app: Application)

    fun injectGoogleMapPresenter(googleMapPresenter: GoogleMapPresenter)


}