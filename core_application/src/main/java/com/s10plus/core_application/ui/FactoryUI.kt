package com.s10plus.core_application.ui

import android.content.Context
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import com.s10plus.core_application.models.*
import com.s10plus.core_application.models.TypeComponent.*

class FactoryUI {
    companion object{

        fun createComponent(context: Context, component:AbstractComponentModel, view:ViewGroup){

            when(component.typeComponent){
                BUTTON -> {
                    ButtonS10Plus.createForModel(context,null,component as ButtonModel,view)
                }
                BUTTON_IMAGE -> {
                    ButtonImageS10Plus.createForModel(context,null,component as ButtonModel,view)
                }
                TEXTVIEW -> {
                    TextViewS1Plus.createForModel(context,null,component as TextViewModel,view)

                }
                LABEL -> TODO()
                CARRUSEL -> TODO()
                IMAGE -> {
                    ImageViewS10Plus.createForModel(context,null,component as ImageModel,view)

                }
                MENU -> TODO()
                MENU_ITEM -> TODO()
                NONE -> TODO()
            }

        }

        fun createLayout(context: Context, layout:AbstractLayoutModel, view: ViewGroup){

            when(layout.typeView ){
                TypeView.CONTENTBOX -> TODO()
                TypeView.LINEAL -> {
                    LinearLayoutS10Plus.createForModel(
                        context = context,null,
                        layout as LinealLayoutModel,view)
                }
                TypeView.GRID -> TODO()
                TypeView.HORIZONTAL -> TODO()
                TypeView.NONE -> LinearLayoutS10Plus.createForModel(
                    context = context,null,
                    layout as LinealLayoutModel,view)
            }

        }

    }
}