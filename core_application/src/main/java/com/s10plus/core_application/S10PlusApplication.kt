package com.s10plus.core_application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class S10PlusApplication: Application(),LifecycleObserver {
    override fun onCreate() {
        super.onCreate()

        currentApplication = this

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)




    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onAppDestroyed(){
        GlobalSettings.saveInterceptorPhone(true,GlobalSettings.getNumberPhone())
        Toast.makeText(this, "Destruyo la app", Toast.LENGTH_LONG).show()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppStoped(){
        GlobalSettings.saveInterceptorPhone(true,GlobalSettings.getNumberPhone())


    }


    companion object{

       lateinit var currentApplication :Context

        fun getCurrentActivity():Activity{

            return  currentApplication as Activity

        }
    }
}