package com.s10plus.core_application.models

import android.view.View
import com.google.gson.annotations.Expose

class ButtonNSModel:AbstractComponentModel() {

    @Expose(serialize = false)
    var urlFacebook: String = ""
        get() = Property.getPropertyValue(properties, KeyProperties.FACEBOOK_URL) ?: ""

    @Expose(serialize = false)
    var urlTwitter: String = ""
        get() = Property.getPropertyValue(properties, KeyProperties.TWITTER_URL) ?: ""

    @Expose(serialize = false)
    var urlYoutube: String =""
        get() = Property.getPropertyValue(properties, KeyProperties.YOUTUBE_URL) ?: ""




    override fun onConfigView(view: View) {

    }
}