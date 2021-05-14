package com.s10plus.core_application.configuration

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.AsyncTask
import android.util.Log
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.s10plus.core_application.BuildConfig
import com.s10plus.core_application.GlobalSettings
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.commons.AbstractComponentAdapter
import com.s10plus.core_application.commons.AbstractLayoutAdapter
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.AbstractLayoutModel
import com.s10plus.core_application.sound.FileService
import com.s10plus.core_application.utils.JsonUtil
import com.s10plus.core_application.utils.Storage

class ConfigurationViewModel:BaseViewModel() {

    val TAG ="ConfigurationViewModel"
    private var service = serverRetrofit.getClientNoUnsafe(FileService::class.java)
    private var tokenService = serverRetrofit.getService(TokenService::class.java)

    fun loadConfigurationCache() {

        var startUpdate = GlobalSettings.validateUpdate()

        if (startUpdate) {


            setupSubscribe(tokenService.getConfig(BuildConfig.ID_APP),
                {

                    if (!GlobalSettings.isConfig())
                        setup(configuration = it.data, true)
                    else
                        setup(configuration = it.data, false)


                }, {

                    GlobalSettings.saveUpdateConfig()
                    GlobalSettings.config =
                        JsonUtil.fromConfiguration(Storage.getFileText(Storage.nameConfig))
                    success.value = "continue"
                    Log.d(TAG, "Configuracion Lista")
                })


        } else {
            GlobalSettings.config =
                JsonUtil.fromConfiguration(Storage.getFileText(Storage.nameConfig))
            success.value = "continue"
            Log.d(TAG, "Configuracion Lista")
        }


    }


    fun load(){


        loader.value = true
        setupSubscribe(tokenService.load(),
            {
                loader.value = false
                //GlobalSettings.setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDQ4NjM5NzgsImV4cCI6MTYwNDg2NzU3OCwiYXVkIjoiNzU1YjU3MDhkN2IxMDhkODE2YzViOTZlOGJkMDExMGU1MzAxMWRhOSIsImRhdGEiOnsicm9sIjoiMSIsImlkX3VzdWFyaW8iOiJ1c2VyMSIsInVzZXJOYW1lIjoiYWxmb25zb2xvcGV6IiwiZnVsbFVzZXJOYW1lIjoiQWxmb25zbyBMXHUwMGYzcGV6IiwiaWRJbnN0aXR1Y2lvbiI6bnVsbH19.ioU-ZSzdaVDX8FcQXLNuKmFesFnmDsxQDS0iSecD6_4")
                if(it.status ==200) {
                    success.value = "finish"
                    GlobalSettings.setToken(it.token!!)
                }

                else
                    error.value=it.message

            },
            {
                success.value = "finish"

            })

    }

    private fun setup(configuration: Configuration, rebirth: Boolean = true) {
        GlobalSettings.setPhones(configuration.preconfiguration.requestPhone.interceptorsPhone)
        GlobalSettings.config = configuration
        var json = Gson().toJson(configuration)
        Storage.writeToDisk(json.toByteArray(), Storage.nameConfig)
        saveSound(configuration.preconfiguration.sound, rebirth)


    }


    private fun saveSound(url: String, rebirth: Boolean = true) {
        if (url.isNullOrEmpty()) {
            if (rebirth)
                triggerRebirth(S10PlusApplication.currentApplication)
            GlobalSettings.setIsConfig(true)
            GlobalSettings.saveUpdateConfig()

            return
        }
        setupSubscribe(service.downloadFile(url), {
            Storage.writeResponseBodyToDisk(it, "sound.mp3")

            Log.d(TAG, "Sound Download")
            GlobalSettings.setIsConfig(true)
            GlobalSettings.saveUpdateConfig()

            if (rebirth) {
                AsyncTask.execute {
                    Thread.sleep(3000)
                    triggerRebirth(S10PlusApplication.currentApplication)
                }
            } else {
                success.value = "continue"

            }

        }, {

            if (rebirth)
                triggerRebirth(S10PlusApplication.currentApplication)

            Log.d(TAG, "OK")

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