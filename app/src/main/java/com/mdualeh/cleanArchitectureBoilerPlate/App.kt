package com.mdualeh.cleanArchitectureBoilerPlate

import android.app.Application
import com.mdualeh.cache.CacheLibrary
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Unique initialization of Cache library to allow saving into device
        CacheLibrary.init(this)

        // Unique initialization of Dependency Injection library to allow the use of application context
        startKoin { androidContext(this@App) }
    }
}
