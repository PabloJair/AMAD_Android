package com.s10plus.core_application.configuration

import com.google.gson.annotations.SerializedName
import com.s10plus.core_application.models.ViewS10Plus


data class Configuration(
    @SerializedName("app_id")
    var appId: String = "",
    @SerializedName("preconfiguration")
    var preconfiguration: Preconfiguration = Preconfiguration(),
    @SerializedName("views")
    var views: List<ViewS10Plus> = listOf()
)

data class Preconfiguration(
    @SerializedName("geolocation")
    var geolocation: Geolocation = Geolocation(),
    @SerializedName("offline")
    var offline: Offline = Offline(),
    @SerializedName("request_phone")
    var requestPhone: RequestPhone = RequestPhone(),
    @SerializedName("sound")
    var sound: String = "",
    @SerializedName("splash_gift")
    var splashGift: String = "",
    @SerializedName("splash_image")
    var splashImage: String = "",
    @SerializedName("splash_lottie")
    var splashLottie: String = "",
    @SerializedName("state")
    var state: State = State(),
    @SerializedName("url-analytics")
    var urlAnalytics: String = "",


)

data class Geolocation(
    @SerializedName("active")
    var active: Boolean = true,
    @SerializedName("url")
    var url: String = ""
)

data class Offline(
    @SerializedName("active")
    var active: Boolean = false,
    @SerializedName("date_update")
    var dateUpdate: DateUpdate = DateUpdate()
)

data class RequestPhone(
    @SerializedName("active")
    var active: Boolean = true,
    @SerializedName("interceptorsPhone")
    var interceptorsPhone: ArrayList<String> = arrayListOf()
)

data class State(
    @SerializedName("active")
    var active: Boolean = true
)

data class DateUpdate(
    @SerializedName("date")
    var date: String = "",
    @SerializedName("time")
    var time: String = "",
    @SerializedName("type")
    var type: String = ""
)