package com.example.tony.eyezon.di.modules

import com.example.tony.eyezon.PinService
import com.example.tony.eyezon.network.PinApi
import dagger.Module
import javax.inject.Singleton
import dagger.Provides





@Module(includes = arrayOf(ApiModule::class))
class PinModule{

    @Provides
    @Singleton
    fun provideGithubService(authApi: PinApi): PinService {
        return PinService(authApi)
    }

}
