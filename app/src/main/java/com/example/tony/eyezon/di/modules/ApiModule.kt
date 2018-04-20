package com.example.tony.eyezon.di.modules

import com.example.tony.eyezon.network.PinApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = arrayOf(RetrofitModule::class))
class ApiModule {
    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): PinApi {
        return retrofit.create(PinApi::class.java);
    }
}