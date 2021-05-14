package com.s10plus.amad

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import com.blankj.utilcode.util.KeyboardUtils
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import com.s10plus.amad.databinding.ActivitySplashBinding
import com.s10plus.core_application.CallReceiverService
import com.s10plus.core_application.GlobalSettings
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.base_ui.BaseActivity
import com.s10plus.core_application.base_ui.BaseFethData
import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.configuration.ConfigurationViewModel
import com.s10plus.core_application.databinding.DialogPhoneBinding
import com.s10plus.core_application.ui.CustomSnackbar
import com.s10plus.core_application.ui.DialogChooseState
import com.s10plus.core_application.ui.dialog.TypeDialog
import com.tbruyelle.rxpermissions3.RxPermissions


class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    //1.- Validar Json de carga, Si no funciona el servicio carga el Json de cache
    //2.- Primera configuracion, validar si esta activo el sonido, si esta activo descargar el mp3 y guardarlo en el dispositvo
    lateinit var configurationViewModel: ConfigurationViewModel
    lateinit var viewNumber: DialogPhoneBinding
    var rxPermissions = RxPermissions(this)
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    var countPermission = 2
    var showMessage = true


    override fun setupView() {
        viewNumber = DialogPhoneBinding.inflate(LayoutInflater.from(this), null, false)
    }

    override fun setupViewModel() {

        configurationViewModel = BaseViewModel.getViewModel(
            this,
            ConfigurationViewModel::class.java
        )

    }

    override fun setupObserver() {
        configurationViewModel.liveDataManager.observe(this, {
            when (it) {
                is BaseFethData.Error -> {

                }
                is BaseFethData.Loader -> {
                }
                is BaseFethData.Success -> {
                    if ((it.data as String) == "finish") {

                        loadInformationUser5()
                    }

                    if ((it.data as String) == "continue") {

                        configurationViewModel.load()
                    }

                }
            }
        })
    }

    override fun init() {

        AsyncTask.execute {
            Thread.sleep(1000)
            runOnUiThread {
                configGeneralStep1()

            }
        }
    }

    private fun getNumber() {
        if (GlobalSettings.getCurrentPhone(true).isNullOrEmpty()
            && GlobalSettings.config.preconfiguration.requestPhone.active
        ) {

            val alert = AlertDialog.Builder(this)
                .setView(viewNumber.root).show().apply { setCancelable(false) }
            viewNumber.cancel.setOnClickListener {
                GlobalSettings.setCurrentPhone("0000000000")
                getState()

            }
            viewNumber.ok.setOnClickListener {
                KeyboardUtils.hideSoftInput(viewNumber.root)
                alert.dismiss()

                (viewNumber.root.parent as ViewGroup).removeView(viewNumber.root)

                val snack =
                    CustomSnackbar.make(
                        binding.root, "¿Es correcto tu número telefonico?",
                        viewNumber.editText.text!!.toString(), "Si", "No",
                        Snackbar.LENGTH_INDEFINITE
                    )
                        .setClickOne {
                            var number =
                                if (viewNumber.editText.text!!.toString() == "") "0000000000"
                                else viewNumber.editText.text!!.toString()
                            GlobalSettings.setCurrentPhone(number)
                            getState()
                        }.setClickTwo {

                            it.dismiss()

                        }
                snack.show()

            }
        } else {
            getState()
        }

    }

    private fun getState() {
        if (GlobalSettings.getState() == null && GlobalSettings.config.preconfiguration.state.active) {
            DialogChooseState.dialogState(this, {
                GlobalSettings.setState(it)
                goToHomeStep6()
            }, {})
        } else
            goToHomeStep6()


    }


    private fun configGeneralStep1() {
        startService(Intent(this, CallReceiverService::class.java))
        rxPermissions.setLogging(true)
        GlobalSettings.saveInterceptorPhone(false)
        validatePermissionAppStep2()

    }

    fun loadInformationUser5() {
        getNumber()
    }

    fun goToHomeStep6() {
        AsyncTask.execute {
            Thread.sleep(100)
            runOnUiThread {
                val mp = MediaPlayer.create(
                    this,
                    S10PlusApplication.currentApplication.getFileStreamPath("sound.mp3").toUri()
                )
                mp.start()
                mp.setOnCompletionListener {}
            }

        }

        S10PlusApplication.currentApplication.startActivity(
            Intent(this, MainActivity::class.java)
        )

        this.finish()
    }

    fun loadConfigurationStep4() {


        configurationViewModel.loadConfigurationCache()

    }

    @SuppressLint("MissingPermission")
    private fun executeLocationStep3() {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation.addOnSuccessListener {
            GlobalSettings.lat = it?.latitude ?: 0.toDouble()
            GlobalSettings.lng = it?.longitude ?: 0.toDouble()
            loadConfigurationStep4()

        }
        fusedLocationClient.lastLocation.addOnFailureListener {
            loadConfigurationStep4()

        }


    }

    private fun validatePermissionAppStep2() {


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

        var permission = arrayListOf(

            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION

        )

        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)) {
            permission.add(Manifest.permission.ANSWER_PHONE_CALLS)
        } else {
            permission.add(Manifest.permission.READ_PHONE_STATE)

        }

        var validatePermission = permission.map { rxPermissions.isGranted(it) }

        if (!validatePermission.contains(false)) {
            executeLocationStep3()
            return
        }

        if (countPermission == 0) {
            executeLocationStep3()
            return
        }

        var permissionValidate = 0


        rxPermissions.setLogging(true)

        rxPermissions.request(
            *permission.toTypedArray()
        ).subscribe {
            if (!it) {
                if (showMessage) {
                    showDialog(
                        TypeDialog.ERROR,
                        title = "Permisos requeridos",
                        "¡Es importante aceptar los permisos requerido para tener una mejor experiencia en tu aplicación!",
                        null, { modal ->
                            countPermission--
                            showMessage = false
                            modal.dismiss()
                            validatePermissionAppStep2()

                        })
                }
            } else {
                permissionValidate++
                if (permissionValidate == 1) {
                    executeLocationStep3()
                }
            }

        }
    }
}