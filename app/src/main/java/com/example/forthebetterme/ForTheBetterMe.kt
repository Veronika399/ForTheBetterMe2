package com.example.forthebetterme

import android.app.Application
import com.example.forthebetterme.di.databaseModule
import com.example.forthebetterme.di.repositoryModule
import com.example.forthebetterme.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin



class ForTheBetterMe: Application() {

    override fun onCreate() {
        super.onCreate()
        application=this

        startKoin{
            androidLogger(if (BuildConfig.DEBUG) org.koin.core.logger.Level.ERROR else org.koin.core.logger.Level.NONE)
            androidContext(this@ForTheBetterMe)
            modules(
                databaseModule,
                repositoryModule,
                viewmodelModule

            )
        }
    }

    companion object{
        lateinit var application:Application
    }
}