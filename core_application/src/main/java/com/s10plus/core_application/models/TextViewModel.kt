package com.s10plus.core_application.models

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.s10plus.core_application.ui.TextViewS1Plus

class TextViewModel : AbstractComponentModel() {

    var textSize: Float = 14f
        get() = Property.getProperty(properties, KeyProperties.SIZE_TEXT)?.value?.toFloat() ?: 14f
    var textAliment: Int = View.TEXT_ALIGNMENT_TEXT_START
        get() = Property.getPropertyValue(properties, KeyProperties.TEXT_ALIGNMENT)?.toInt()
            ?: View.TEXT_ALIGNMENT_TEXT_START

    override fun onConfigView(view: View) {
        val view = view as TextViewS1Plus

        view.textSize = textSize

        view.textAlignment = textAliment
        view.gravity = Gravity.CENTER_VERTICAL
        view.setTextColor(Color.parseColor(textColor))


    }


}