package com.s10plus.core_application.models

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.gson.annotations.Expose
import com.s10plus.core_application.GlobalSettings
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.activities.ViewActivity
import com.s10plus.core_application.base_ui.ActivityUtils
import com.s10plus.core_application.utils.JsonUtil
import kotlinx.android.parcel.RawValue


abstract class AbstractComponentModel(
    var properties: @RawValue ArrayList<Property> = arrayListOf()
) {

    var typeComponent: TypeComponent = TypeComponent.NONE
    @Expose
    var text: String = ""
        get() = Property.getPropertyValue(properties, KeyProperties.TEXT) ?: ""
    @Expose
    var textColor = ""
        get() = Property.getPropertyValue(properties, KeyProperties.COLOR) ?: "#000000"
    @Expose
    var padding: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.PADDING)?.valueToIntArray(" ")
    @Expose
    var size: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.SIZE)?.valueToIntArray(" ")
    @Expose
    var margin: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.MARGIN)?.valueToIntArray(" ")
    @Expose
    var cornerRadius: String? = null
        get() = Property.getProperty(properties, KeyProperties.CORNER_RADIUS)?.value
    @Expose
    var background: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.BACKGROUND)
    @Expose
    var gradientBackground: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.COLOR_GRADIENT)
            ?.split(" ")?.map { Color.parseColor(it) }
    @Expose
    private var view: View? = null

    @Expose
    var sendToView: String?=null
        get()= Property.getPropertyValue(properties, KeyProperties.SEND_TO_VIEW)


    @Expose
    var backView: String?=null
        get()= Property.getPropertyValue(properties, KeyProperties.BACK_VIEW)


    @Expose
    var openUrl: String?=null
        get()= Property.getPropertyValue(properties, KeyProperties.OPEN_URL)
    abstract fun onConfigView(view: View)

    open fun init(view: View) {
        this.view = view
        onPreConfiguration(view)
        onConfigView(view)
    }

    open fun realoadView() {

        this.init(this.view!!)
    }

    open fun onPreConfiguration(view: View) {


        val shape = ShapeDrawable()
        size?.let {
            if(view.layoutParams is LinearLayout.LayoutParams){
                view.layoutParams = LinearLayout.LayoutParams(it[0], it[1])
            }else{
                view.layoutParams = ViewGroup.MarginLayoutParams(it[0], it[1])

            }
        }
        margin?.let {
            (view.layoutParams as ViewGroup.MarginLayoutParams).setMargins(it[0], it[1], it[2], it[3])
        }
        padding?.let { view.setPadding(it[0], it[1], it[2], it[3]) }

        cornerRadius?.let {

            val radius = it.toFloat()
            shape.shape = RoundRectShape(
                floatArrayOf(radius, radius, radius, radius, radius, radius, radius, radius),
                null, null)
            view.background = shape
        }
        background?.let {
            shape.paint.color = Color.parseColor(it)
            view.background = shape
        }

        gradientBackground?.let {
            val shader = object : ShapeDrawable.ShaderFactory() {
                override fun resize(width: Int, height: Int): Shader {

                    return LinearGradient(
                        0f, 0f, 0f,
                        view.height.toFloat(),
                        it[0],
                        it[1],
                        Shader.TileMode.CLAMP
                    )
                }
            }
            shape.shaderFactory = shader
            view.background = shape

        }



        sendToView?.let {
            val viewS10Plus =  GlobalSettings.getView(it)
            if(viewS10Plus!=null){
                goTo(viewS10Plus)
            }
        }

        backView?.let { backView() }


        openUrl?.let { goToUrl(it) }



    }

    private fun goTo(viewS10Plus: ViewS10Plus)=
        view?.setOnClickListener {
            S10PlusApplication.currentApplication.startActivity(
                Intent(view!!.context, ViewActivity::class.java)
                    .putExtra(ViewActivity.VIEWS10PLUS, JsonUtil.toJson(viewS10Plus))
            )

        }





    private fun backView() =
        view?.setOnClickListener {
            S10PlusApplication.getCurrentActivity().onBackPressed()

        }


    private fun goToUrl(url: String) =
        view?.setOnClickListener {
            ActivityUtils.openWebView(view!!.context,url)

        }



}