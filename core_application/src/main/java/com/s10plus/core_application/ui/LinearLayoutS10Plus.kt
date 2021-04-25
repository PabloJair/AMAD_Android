package com.s10plus.core_application.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import com.s10plus.core_application.models.*

@SuppressLint("ViewConstructor")
class LinearLayoutS10Plus(context: Context, attrs: AttributeSet? = null)
    : LinearLayout(context, attrs), ILayoutModel {


    override fun configuration(component: AbstractLayoutModel) {


        orientation = VERTICAL
        component.childs.forEach {
            FactoryUI.createComponent(context,it,this)
        }
    }
    companion object{
        fun createForModel(context: Context, attrs: AttributeSet?=null,
                           model: LinealLayoutModel = LinealLayoutModel(), view: ViewGroup,
                           canCreateSubViews:Boolean = true): LinearLayoutS10Plus {
            return  LinearLayoutS10Plus(context,attrs).apply {

                configuration(model)
                view.addView(this)
            }

        }
    }




}