package com.s10plus.amad

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatDelegate
import com.s10plus.amad.databinding.ActivityMainBinding
import com.s10plus.core_application.GlobalSettings
import com.s10plus.core_application.analytics.AnalyticsViewModel
import com.s10plus.core_application.base_ui.BaseActivity
import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.models.ViewS10Plus
import com.s10plus.core_application.ui.FactoryUI
import com.squareup.picasso.Picasso


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    var view: ViewS10Plus? = null

    lateinit var analyticsViewModel: AnalyticsViewModel
    override fun setupView() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        setupHeader()
        setupBody()
        setupFooter()

        AnalyticsViewModel.onSendAnalytics = {
            analyticsViewModel.sendClicks(it.IdAction, it.Concept)

        }
    }

    override fun setupHeader() {


        //view?.header?.layout?.init(binding.header)

    }


    override fun setupBody() {


        GlobalSettings.config.views.find { viewS10Plus -> viewS10Plus.id == "0" }?.body?.layout?.let {
            FactoryUI.createBody(this, it, binding.body)
        }


        /* view?.body?.layout?.let {
             FactoryUI.createLayout(this,it,binding.body)
         }*/

    }


    override fun setupFooter() {

        GlobalSettings.config.views.find { viewS10Plus -> viewS10Plus.id == "0" }?.footer?.layout?.let {
            FactoryUI.createFooter(this, it, binding.rootFooter)
        }



        AsyncTask.execute {
            Thread.sleep(3000)
            this.runOnUiThread {
                binding.body.smoothScrollTo(0, binding.body.bottom)

            }

        }

    }

    override fun onResume() {
        super.onResume()

        FactoryUI.rootViewBody = binding.body
        FactoryUI.rootViewFooter = binding.rootFooter

        // FactoryUI.rootViewHeader = binding.

    }

    override fun setupViewModel() {
        analyticsViewModel = BaseViewModel.getViewModel(this, AnalyticsViewModel::class.java)
    }

    override fun setupObserver() {
    }

    override fun init() {
        Picasso.get().isLoggingEnabled = true
        //Picasso.get().setIndicatorsEnabled(true)

        //val db = Firebase.firestore


        /*db.collection("/test").document("EekyX3rNZzkicutjVIyG")
            .set(Mocks.createView())*/

        /* db.collection("/test").document("EekyX3rNZzkicutjVIyG")
              .get().addOnSuccessListener {

                  view  = gson.fromJson(gson.toJson(it.data),ViewS10Plus::class.java)
                  reloadData()
              }*/

    }

    private fun reloadData() {
        binding.body.removeAllViews()
        binding.header.removeAllViews()
        binding.rootFooter.removeAllViews()
        setupView()


    }

    companion object

}