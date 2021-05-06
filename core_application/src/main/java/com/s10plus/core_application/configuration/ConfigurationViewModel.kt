package com.s10plus.core_application.configuration

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.AsyncTask
import android.util.Log
import androidx.annotation.RawRes
import com.blankj.utilcode.util.LogUtils
import com.google.common.reflect.Reflection.getPackageName
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.s10plus.core_application.GlobalSettings
import com.s10plus.core_application.R
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.base_ui.ActivityUtils
import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.commons.AbstractComponentAdapter
import com.s10plus.core_application.commons.AbstractLayoutAdapter
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.AbstractLayoutModel
import com.s10plus.core_application.sound.FileService
import com.s10plus.core_application.utils.JsonUtil
import com.s10plus.core_application.utils.Storage
import java.io.InputStream

class ConfigurationViewModel:BaseViewModel() {

    val TAG ="ConfigurationViewModel"
    private var service = serverRetrofit.getClientNoUnsafe(FileService::class.java)

    fun loadConfigurationCache() {


        if(!GlobalSettings.isConfig()){
            var config = readRawJson<Configuration>(R.raw.config)

            setup(config)

        }else{
            GlobalSettings.config = JsonUtil.fromConfiguration(Storage.getFileText(Storage.nameConfig))
            success.value="OK"
            Log.d(TAG,"Configuracion Lista")
            // GlobalSettings.setIsConfig(true)

        }


    }

    private fun setup(configuration: Configuration){
        GlobalSettings.setPhones(configuration.preconfiguration.requestPhone.interceptorsPhone)
        GlobalSettings.config = configuration
        var json  =Gson().toJson(configuration)
        Storage.writeToDisk(json.toByteArray(),Storage.nameConfig)
        saveSound(configuration.preconfiguration.sound)


    }

    private fun saveSound(url:String){
        if (url.isNullOrEmpty()){
            triggerRebirth(S10PlusApplication.currentApplication)
            GlobalSettings.setIsConfig(true)
            return
        }
        setupSubscribe(service.downloadFile(url), {
            Storage.writeResponseBodyToDisk(it,"sound.mp3");

            Log.d(TAG,"Sound Download")
            GlobalSettings.setIsConfig(true)


            AsyncTask.execute {
                Thread.sleep(3000)
                triggerRebirth(S10PlusApplication.currentApplication)
            }

        },{

            triggerRebirth(S10PlusApplication.currentApplication)

            Log.d(TAG,"OK")

        })

    }
    private inline fun <reified T> readRawJson(@RawRes rawResId: Int): T {
        val gson = GsonBuilder()
            .registerTypeAdapter(AbstractLayoutModel::class.java, AbstractLayoutAdapter())
            .registerTypeAdapter(AbstractComponentModel::class.java, AbstractComponentAdapter())
            .setPrettyPrinting().create()
        S10PlusApplication.currentApplication.resources.openRawResource(rawResId).bufferedReader().use {
            return gson.fromJson(it, object: TypeToken<T>() {}.type)
        }
    }

    fun triggerRebirth(context: Context) {
        val packageManager: PackageManager = context.packageManager
        val intent = packageManager.getLaunchIntentForPackage(context.packageName)
        val componentName = intent!!.component
        val mainIntent = Intent.makeRestartActivityTask(componentName)
        context.startActivity(mainIntent)
        Runtime.getRuntime().exit(0)
    }

}