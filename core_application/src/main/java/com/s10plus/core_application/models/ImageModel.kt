package com.s10plus.core_application.models

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.s10plus.core_application.ui.ImageViewS10Plus
import com.s10plus.core_application.ui.TextViewS1Plus
import com.squareup.picasso.Picasso

class ImageModel: AbstractComponentModel() {

    @Expose
    var ulrImage = ""
        get() = Property.getPropertyValue(properties,KeyProperties.URL_IMAGE)?:""

     override fun onConfigView(view: View) {


     }


 }