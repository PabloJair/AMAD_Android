package com.s10plus.amad

import androidx.lifecycle.Observer
import com.s10plus.amad.databinding.ActivityMainBinding
import com.s10plus.amad.databinding.ActivitySplashBinding
import com.s10plus.core_application.base_ui.BaseActivity
import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.configuration.ConfigurationViewModel
import com.s10plus.core_application.sound.FileViewModel

class SplashActivity:BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    //1.- Validar Json de carga, Si no funciona el servicio carga el Json de cache
    //2.- Primera configuracion, validar si esta activo el sonido, si esta activo descargar el mp3 y guardarlo en el dispositvo
   lateinit var viewModel:FileViewModel
    lateinit var configurationViewModel: ConfigurationViewModel

    override fun setupView() {
    }

    override fun setupViewModel() {
        viewModel = BaseViewModel.getViewModel(this,FileViewModel::class.java)
        configurationViewModel = BaseViewModel.getViewModel(this,ConfigurationViewModel::class.java)

    }

    override fun setupObserver() {
        viewModel.liveDataManager.observe(this, {})
    }

    override fun init() {
       // viewModel.getFile("https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/intro.mp3?alt=media&token=832e01b7-38ab-40c4-842f-85af9ea9d768")

        configurationViewModel.loadConfigurationCache()
    }


    fun preConfiguration(){
    }


}