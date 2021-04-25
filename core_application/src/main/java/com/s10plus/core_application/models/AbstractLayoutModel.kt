package com.s10plus.core_application.models

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import kotlinx.android.parcel.Parcelize

abstract class AbstractLayoutModel() {
    var typeView: TypeView = TypeView.NONE
    private var viewGroup: ViewGroup? = null
    var childs:ArrayList<AbstractComponentModel> = arrayListOf()
    var properties: ArrayList<Property> = arrayListOf()

    abstract fun onConfigurationLayout(viewGroup: ViewGroup);

     open fun init(viewGroup: ViewGroup) {
        this.viewGroup = viewGroup
        onPreConfiguration(viewGroup)
        onConfigurationLayout(viewGroup)
    }
    protected open fun onPreConfiguration(view: ViewGroup) {


        view.layoutParams  =
            ViewGroup.LayoutParams(
                ViewGroup.MarginLayoutParams.MATCH_PARENT,
                ViewGroup.MarginLayoutParams.MATCH_PARENT)
        Property.getPropertyValue(properties, KeyProperties.SIZE)?.let {

            it.split(" ").map { it.toInt() }.also {
                view.layoutParams = ViewGroup.MarginLayoutParams(it[0], it[1]) }

        }
        Property.getPropertyValue(properties, KeyProperties.MARGIN)?.let {

            it.split(" ").map { it.toInt() }.also {
                val marginParams =
                    view.layoutParams as ViewGroup.MarginLayoutParams
                marginParams.setMargins(it[0], it[1], it[2], it[3])
            }

        }

        Property.getPropertyValue(properties, KeyProperties.BACKGROUND)?.let {

            view.setBackgroundColor(Color.parseColor(it))


        }

        Property.getPropertyValue(properties, KeyProperties.CORNER_RADIUS)?.let {

            val radius = it.toFloat()
            val shapeDrawable = ShapeDrawable(
                RoundRectShape(
                    floatArrayOf(
                        radius, radius, radius, radius, radius, radius, radius, radius
                    ),
                    null, null
                )
            ).apply {
                paint.color = (view.background as ColorDrawable).color
            }
            view.background = shapeDrawable


        }


    }

}