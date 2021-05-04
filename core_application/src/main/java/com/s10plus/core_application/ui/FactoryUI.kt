package com.s10plus.core_application.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import com.s10plus.core_application.models.*
import com.s10plus.core_application.models.TypeComponent.*

class FactoryUI {
    companion object{

        var rootViewBody: View? = null
        var rootViewFooter: View? = null
        var rootViewHeader: View? = null

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
                REDES_SOCIALES -> ButtonNSBecas.createForModel(context,null,component as ButtonNSModel,view)
            }

        }

        fun createBody(context: Context, layout:AbstractLayoutModel, view: ViewGroup){

            this.rootViewBody = view
            createLayout(context,layout, view)

        }
        fun createFooter(context: Context, layout:AbstractLayoutModel, view: ViewGroup){
            this.rootViewFooter = view

            createLayout(context,layout, view)


        }
        fun createHeader(context: Context, layout:AbstractLayoutModel, view: ViewGroup){
            this.rootViewHeader = view

            createLayout(context,layout, view)


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