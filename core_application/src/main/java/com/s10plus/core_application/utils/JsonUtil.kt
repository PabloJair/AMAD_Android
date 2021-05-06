package com.s10plus.core_application.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.s10plus.core_application.commons.AbstractComponentAdapter
import com.s10plus.core_application.commons.AbstractLayoutAdapter
import com.s10plus.core_application.configuration.Configuration
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.AbstractLayoutModel
import com.s10plus.core_application.models.ViewS10Plus
import java.lang.reflect.Type


object JsonUtil {

    fun toJson(src: Any)=Gson().toJson(src)
    fun <T>fromJson(json: String):T {

        return  GsonBuilder()
            .registerTypeAdapter(AbstractLayoutModel::class.java, AbstractLayoutAdapter())
            .registerTypeAdapter(AbstractComponentModel::class.java, AbstractComponentAdapter())
            .setPrettyPrinting().create().fromJson(json,object : TypeToken<T>() {}.type)
    }

    fun fromViewS10plus(json: String):ViewS10Plus {

        return  GsonBuilder()
            .registerTypeAdapter(AbstractLayoutModel::class.java, AbstractLayoutAdapter())
            .registerTypeAdapter(AbstractComponentModel::class.java, AbstractComponentAdapter())
            .setPrettyPrinting().create().fromJson(json,ViewS10Plus::class.java)
    }

    fun fromConfiguration(json: String): Configuration {

        return  GsonBuilder()
            .registerTypeAdapter(AbstractLayoutModel::class.java, AbstractLayoutAdapter())
            .registerTypeAdapter(AbstractComponentModel::class.java, AbstractComponentAdapter())
            .setPrettyPrinting().create().fromJson(json,Configuration::class.java)
    }

}