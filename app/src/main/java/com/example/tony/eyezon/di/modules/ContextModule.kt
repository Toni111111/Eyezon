package com.example.tony.eyezon.di.modules

import android.content.Context
import dagger.Module
import javax.inject.Singleton
import dagger.Provides



/**
 * Created by Tony on 15.04.2018.
 */
@Module
class ContextModule(private var mContext: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return mContext;
    }

}