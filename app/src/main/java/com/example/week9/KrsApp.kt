package com.example.week9

import android.app.Application
import com.example.week9.dependeciesinjection.ContainerApp

class KrsApp: Application() {
    lateinit var containerApp: ContainerApp
    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}