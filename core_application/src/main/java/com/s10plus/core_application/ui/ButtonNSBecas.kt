package com.s10plus.core_application.ui

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.core.content.ContextCompat

import com.s10plus.core_application.R
import com.s10plus.core_application.databinding.ButtonNsBinding
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.ButtonNSModel
import com.s10plus.core_application.models.KeyProperties
import com.s10plus.core_application.models.Property


class ButtonNSBecas(context: Context, var attrs: AttributeSet?=null,
                    override var component: AbstractComponentModel
):
        LinearLayout(context, attrs),ILiveCycleComponentView {

    private val binding:ButtonNsBinding  = ButtonNsBinding.inflate(LayoutInflater.from(context),this,true)


    override fun onConfiguration() {
        var component =component as ButtonNSModel

        component.init(binding.rootView)


        binding.rootView.setOnClickListener {

            binding.rs.visibility = if(binding.rs.visibility == GONE) VISIBLE else GONE

            AbstractComponentModel.sendAnalytics("59|nav|CLICK/REDES_SOCIALES|Redes Sociales|Redes Sociales")
            if( FactoryUI.rootViewBody is ScrollView){
               (FactoryUI.rootViewBody as ScrollView).apply {

                   post {

                       this.smoothScrollTo(0,this.bottom+this@ButtonNSBecas.height)

                   }
               }
           }
        }



        binding.text.text =component.text


        binding.youtube.visibility = if(component.urlYoutube.isNullOrEmpty()) GONE else VISIBLE
        binding.twitter.visibility = if(component.urlTwitter.isNullOrEmpty()) GONE else VISIBLE
        binding.facebook.visibility = if(component.urlFacebook.isNullOrEmpty()) GONE else VISIBLE

        if(!component.openUrl.isNullOrEmpty()){
            AbstractComponentModel.goToUrl(component.urlFacebook,binding.facebook,  "64|nav|CLICK/REDES SOCIALES:|FACEBOOK|FACEBOOK")
            AbstractComponentModel.goToUrl(component.urlTwitter,binding.twitter,    "63|nav|CLICK/REDES SOCIALES:|TWITTER|TWITTER"  )
            AbstractComponentModel.goToUrl(component.urlYoutube,binding.youtube,    "65|nav|CLICK/REDES SOCIALES:|YOUTUBE|YOUTUBE"  )

        }else {
            AbstractComponentModel.goToUrlInternal(component.urlFacebook,binding.facebook   ,"64|nav|CLICK/REDES SOCIALES:|FACEBOOK|FACEBOOK")
            AbstractComponentModel.goToUrlInternal(component.urlTwitter,binding.twitter     ,"63|nav|CLICK/REDES SOCIALES:|TWITTER|TWITTER"  )
            AbstractComponentModel.goToUrlInternal(component.urlYoutube,binding.youtube     ,"65|nav|CLICK/REDES SOCIALES:|YOUTUBE|YOUTUBE"  )
        }

    }


    companion object{
        fun createForModel(context: Context, attrs: AttributeSet?=null, model: ButtonNSModel = ButtonNSModel(), view: ViewGroup): ButtonNSBecas {
            return  ButtonNSBecas(context,attrs,model).apply {
                onConfiguration()
                view.addView(this)
            }

        }

    }



}