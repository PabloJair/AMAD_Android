package com.s10plus.core_application.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.ImageModel

import com.squareup.picasso.Picasso

@SuppressLint("AppCompatCustomView")
class ImageViewS10Plus(context: Context, attrs: AttributeSet?=null,
                       override var component: AbstractComponentModel = ImageModel()
) :
        ImageView(context,attrs),ILiveCycleComponentView {


    override fun onConfiguration() {
        component.init(this)

        var model =  component as ImageModel
        Picasso.get().load(model.ulrImage).fit().into(this)



    }



    init {
        onConfiguration()

    }


    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

    }
    companion object{

        fun createForModel(context: Context, attrs: AttributeSet?=null,
                           imageModel: ImageModel= ImageModel(), view: ViewGroup): ImageViewS10Plus {
            return  ImageViewS10Plus(context,attrs,imageModel).also {
                view.addView(it)

            }

        }

    }


}