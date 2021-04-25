package com.s10plus.core_application.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.Button
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.ButtonModel


@SuppressLint("AppCompatCustomView")
class ButtonS10Plus(context: Context, attrs: AttributeSet? = null,
                    override var component: AbstractComponentModel = ButtonModel()
)
    : Button(context, attrs),ILiveCycleComponentView {

    override fun onConfiguration() {
        val buttonComponent =component as  ButtonModel
        component.init(this)
        text = component.text
        setTextColor(Color.parseColor(buttonComponent.textColor))




    }


    init {
        onConfiguration();

    }


    companion object{
        fun createForModel(
            context: Context, attrs: AttributeSet? = null,
            model: ButtonModel = ButtonModel(), view: ViewGroup
        ): ButtonS10Plus {
            return  ButtonS10Plus(context, attrs,model).apply {
                view.addView(this)


            }

        }

    }
}