package com.example.vms_swe

import android.app.Application
import com.example.data.di.mapperModule
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.vms_swe.di.useCaseModule
import com.example.vms_swe.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

class CustomApplication : Application() {
    private val modulesToUse = listOf(
        networkModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
        mapperModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@CustomApplication)
            parametersOf("http://35.207.161.15:8080")
            modules(modulesToUse)
        }
    }
}