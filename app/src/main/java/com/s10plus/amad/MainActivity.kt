package com.s10plus.amad

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.s10plus.amad.databinding.ActivityMainBinding
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.base_ui.BaseActivity
import com.s10plus.core_application.commons.AbstractComponentAdapter
import com.s10plus.core_application.commons.AbstractLayoutAdapter
import com.s10plus.core_application.mocks.BecasAmad
import com.s10plus.core_application.mocks.Mocks
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.AbstractLayoutModel
import com.s10plus.core_application.models.ViewS10Plus
import com.s10plus.core_application.ui.FactoryUI
import com.squareup.picasso.Picasso


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    var view:ViewS10Plus?=null
    override fun setupView() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        setupHeader()
        setupBody()
        setupFooter()


    }

    override fun setupHeader() {


        //view?.header?.layout?.init(binding.header)

    }


    override fun setupBody() {


        BecasAmad.MenuHome().body.layout.let {
            FactoryUI.createLayout(this,it,binding.body)
        }

       /* view?.body?.layout?.let {
            FactoryUI.createLayout(this,it,binding.body)
        }*/

    }



    override fun setupFooter() {

       BecasAmad.MenuHome().footer.layout.let {
           FactoryUI.createLayout(this,it,binding.rootFooter)
       }

    }

    override fun setupViewModel() {
    }

    override fun setupObserver() {
    }

    override fun init() {
        Picasso.get().isLoggingEnabled = true
        Picasso.get().setIndicatorsEnabled(true)

        val db = Firebase.firestore




        /*db.collection("/test").document("EekyX3rNZzkicutjVIyG")
            .set(Mocks.createView())*/

      /* db.collection("/test").document("EekyX3rNZzkicutjVIyG")
            .get().addOnSuccessListener {

                view  = gson.fromJson(gson.toJson(it.data),ViewS10Plus::class.java)
                reloadData()
            }*/

    }
    private fun reloadData(){
        binding.body.removeAllViews()
        binding.header.removeAllViews()
        binding.rootFooter.removeAllViews()
        setupView()


    }
    companion object{

    }

}