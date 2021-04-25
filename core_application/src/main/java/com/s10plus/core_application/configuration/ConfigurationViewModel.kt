package com.s10plus.core_application.configuration

import androidx.annotation.RawRes
import com.blankj.utilcode.util.LogUtils
import com.google.common.reflect.Reflection.getPackageName
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.s10plus.core_application.R
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.commons.AbstractComponentAdapter
import com.s10plus.core_application.commons.AbstractLayoutAdapter
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.AbstractLayoutModel
import java.io.InputStream

class ConfigurationViewModel:BaseViewModel() {


    fun loadConfigurationCache() {

        var json = readRawJson<Configuration>(R.raw.config)


        LogUtils.d(json)



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

}