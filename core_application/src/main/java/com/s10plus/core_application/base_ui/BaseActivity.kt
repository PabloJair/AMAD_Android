package com.s10plus.core_application.base_ui

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.models.ViewS10Plus
import com.s10plus.core_application.ui.dialog.LoaderDialog
import com.s10plus.core_application.ui.dialog.ModalGenericDialog
import com.s10plus.core_application.ui.dialog.TypeDialog

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private var idLayout: Int):AppCompatActivity(){

    lateinit var binding: T
    abstract fun setupView()
    abstract fun setupViewModel()
    abstract fun setupObserver()


    open fun setupInjection(){}
    open var layoutIdFragment:Int = 0


    abstract fun init()



    open fun setupAppBar(toolbar: Toolbar, title: String){

        toolbar.title =title

        setSupportActionBar(toolbar)

    }

    private fun setupConfig(){

        binding = DataBindingUtil.setContentView(this, idLayout)
        S10PlusApplication.currentApplication= this
    }

    override fun onResume() {
        super.onResume()
        S10PlusApplication.currentApplication= this

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupConfig()
        setupInjection()
        setupView()
        setupViewModel()
        setupObserver()
        init()
    }

    open  fun showLoader()= LoaderDialog.showDialog(supportFragmentManager)
    open  fun hideLoader()= LoaderDialog.hideDialog()
    open  fun showDialog(
        typeDialog: TypeDialog,
        title: String,
        message: String,
        cancel: ((ModalGenericDialog) -> Unit)? = null,
        ok: ((ModalGenericDialog) -> Unit)? = null
    ){

        when(typeDialog){
            TypeDialog.INFORMATION -> ModalGenericDialog.showInformationDialog(
                supportFragmentManager,
                title,
                message,
                onClickButton1 = cancel,
                onClickButton2 = ok
            )
            TypeDialog.SUCCESS -> ModalGenericDialog.showSuccessDialog(
                supportFragmentManager,
                title,
                message,
                onClickButton1 = cancel,
                onClickButton2 = ok
            )
            TypeDialog.ERROR -> ModalGenericDialog.showErrorDialog(
                supportFragmentManager,
                title,
                message,
                onClickButton1 = cancel,
                onClickButton2 = ok
            )
            TypeDialog.WARMING -> ModalGenericDialog.showWarmingDialog(
                supportFragmentManager,
                title,
                message,
                onClickButton1 = cancel,
                onClickButton2 = ok
            )

            else -> {}
        }
    }
    open  fun assignFragment(layoutId: Int = layoutIdFragment, fragment: Fragment)=supportFragmentManager.beginTransaction().replace(
        layoutId,
        fragment
    ).commit()
    open  fun assignFragmentBackStack(layoutId: Int = layoutIdFragment, fragment: Fragment)=
        supportFragmentManager.apply {

        }.beginTransaction().addToBackStack(null).replace(layoutId, fragment).commit()


    open fun setupHeader(){

    }
    open fun setupFooter(){

    }
    open fun setupBody(){

    }

}