package com.s10plus.core_application.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.Button
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.ButtonModel
import com.s10plus.core_application.models.KeyProperties
import com.s10plus.core_application.models.Property
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

class ButtonImageS10Plus(
    context: Context, attrs: AttributeSet? = null,
    override var component: AbstractComponentModel = ButtonModel()
)
    : Button(context, attrs),ILiveCycleComponentView {

    val TAG = "ButtonImageS10Plus";

    var target = CustomViewTarget(this)

    override fun onConfiguration() {

        component.init(this)
        val buttonComponent =component as  ButtonModel
        text = component.text

        Property.getPropertyValue(
            component.properties,
            KeyProperties.URL_IMAGE
        )?.let {

            Picasso.get().load(it).resize(60, 60)
                .into(target)

            setTextColor(Color.parseColor(buttonComponent.textColor))

        }



    }

    class CustomViewTarget(val button: Button):Target{
        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
            setImageLeft(bitmap!!)
        }

        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
        }
        private fun setImageLeft(bitmap: Bitmap){

            val drawable = BitmapDrawable(button.resources, bitmap)
            drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight);

            button
                . setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
            button.setPaddingRelative(10, 10, 10, 10)
            button.invalidate()


        }
    }

  init {

      onConfiguration()

  }



    companion object{
        fun createForModel(
            context: Context, attrs: AttributeSet? = null,
            model: ButtonModel = ButtonModel(), view: ViewGroup
        ): ButtonImageS10Plus {
            return  ButtonImageS10Plus(context, attrs, model).apply {
                view.addView(this)


            }

        }

    }
}