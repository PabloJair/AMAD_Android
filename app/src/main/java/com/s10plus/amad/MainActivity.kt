package com.s10plus.amad

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.s10plus.amad.databinding.ActivityMainBinding
import com.s10plus.core_application.CallReceiverService
import com.s10plus.core_application.GlobalSettings
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.base_ui.ActivityUtils
import com.s10plus.core_application.base_ui.BaseActivity
import com.s10plus.core_application.commons.AbstractComponentAdapter
import com.s10plus.core_application.commons.AbstractLayoutAdapter
import com.s10plus.core_application.mocks.BecasAmad
import com.s10plus.core_application.mocks.Mocks
import com.s10plus.core_application.models.AbstractComponentModel
import com.s10plus.core_application.models.AbstractLayoutModel
import com.s10plus.core_application.models.ViewS10Plus
import com.s10plus.core_application.ui.FactoryUI
import com.s10plus.core_application.ui.dialog.TypeDialog
import com.s10plus.core_application.ui.horizontal_carrousel.BasicHorizontalCarrouselAdapter
import com.s10plus.core_application.ui.horizontal_carrousel.BasicHorizontalCarruselModel
import com.s10plus.core_application.ui.social_network.DialogSocialNetwork
import com.squareup.picasso.Picasso
import com.tbruyelle.rxpermissions3.RxPermissions


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val adapter: BasicHorizontalCarrouselAdapter by lazy { BasicHorizontalCarrouselAdapter() }
    var rxPermissions = RxPermissions(this)

    override fun setupView() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        adapter.items = arrayListOf(
            BasicHorizontalCarruselModel("Imagen 1",resourceId = R.drawable.image_11),
            BasicHorizontalCarruselModel("Imagen 2",resourceId = R.drawable.image_12),
            BasicHorizontalCarruselModel("Imagen 2",resourceId = R.drawable.image_13),
        )
        binding.horizontalCarouselRecyclerView.init<BasicHorizontalCarrouselAdapter>(adapter)

        binding.download.setOnClickListener {

            ActivityUtils.openWebView(this,"https://play.google.com/store/apps/details?id=uk.co.separatereality.vadsa.mobile.myExis")
        }
        binding.CA.setOnClickListener {

            //ActivityUtils.openWebView(this,"https://play.google.com/store/apps/details?id=uk.co.separatereality.vadsa.mobile.myExis")
        }
        binding.RA.setOnClickListener {

           // ActivityUtils.openWebView(this,"https://play.google.com/store/apps/details?id=uk.co.separatereality.vadsa.mobile.myExis")
        }
        binding.planes.setOnClickListener {

            ActivityUtils.openWebView(this,"https://exis.mx/#/plans/")
        }
        binding.p.setOnClickListener {

            //ActivityUtils.openWebView(this,"https://play.google.com/store/apps/details?id=uk.co.separatereality.vadsa.mobile.myExis")
        }
        binding.CS.setOnClickListener {

            //ActivityUtils.openWebView(this,"https://play.google.com/store/apps/details?id=uk.co.separatereality.vadsa.mobile.myExis")
        }

        binding.contact.setOnClickListener {

            ActivityUtils.openWebView(this,"https://exis.mx/#/contactus")
        }

        binding.dm.setOnClickListener {

            ActivityUtils.openWebView(this,"https://crm.altanredes.com/preactiva/checkimeiv2.php")
        }

        binding.RS.setOnClickListener {

            DialogSocialNetwork.show(supportFragmentManager,click = {
                a,b->
                ActivityUtils.openWebView(this,a)
                b.dismiss()

            })
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + this.packageName)
                )
                startActivityForResult(intent, 12345)
            } else {
                //Permission Granted-System will work
            }
        }
        startService(Intent(this, CallReceiverService::class.java))

        rxPermissions.setLogging(true)
        var answare =if((Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)){rxPermissions.isGranted(
            Manifest.permission.ANSWER_PHONE_CALLS
        )} else true
        GlobalSettings.saveInterceptorPhone(true)
        if(
            rxPermissions.isGranted(Manifest.permission.READ_PHONE_STATE)
            && rxPermissions.isGranted(Manifest.permission.CALL_PHONE)
            && answare
            && rxPermissions.isGranted(Manifest.permission.READ_CALL_LOG)
            && rxPermissions.isGranted(Manifest.permission.ACCESS_FINE_LOCATION)
            && rxPermissions.isGranted(Manifest.permission.ACCESS_COARSE_LOCATION)


        ){
            return
        }


        validatePermission()



    }




    override fun setupHeader() {


        //view?.header?.layout?.init(binding.header)

    }





    override fun setupObserver() {
    }

    override fun init() {


    }

    companion object{

    }

    override fun setupViewModel() {
    }

    private fun validatePermission(){


        var permissionValidate =0

        var permissions = if((Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)){
            arrayOf(
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ANSWER_PHONE_CALLS,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        else{
            arrayOf(
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }

        rxPermissions.request(
            *permissions
        ).subscribe {
            if(!it)
            showDialog(
                TypeDialog.ERROR,
                title = "Permisos requeridos",
                "¡Es importante aceptar los permisos requerido para tener una mejor experiencia en tu aplicación!",
                null, { modal ->
                    modal.dismiss()

                })

        }
    }



}