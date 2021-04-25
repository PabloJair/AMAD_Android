package com.s10plus.core_application.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.TextViewModel

@SuppressLint("AppCompatCustomView")
class TextViewS1Plus(context: Context, attrs: AttributeSet?=null,
                     override var component: AbstractComponentModel= TextViewModel()
)
    : TextView(context,attrs),ILiveCycleComponentView {


    override fun onConfiguration() {
        component.init(this)
        text = component.text
    }



    init {
        onConfiguration()

    }
    companion object{

        fun createForModel(context: Context, attrs: AttributeSet?=null, model: TextViewModel= TextViewModel(), view: ViewGroup): TextViewS1Plus {
            return  TextViewS1Plus(context,attrs,model).apply {
                view.addView(this)
            }

        }

    }




}