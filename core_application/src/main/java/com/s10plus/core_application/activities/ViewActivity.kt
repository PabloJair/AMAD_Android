package com.s10plus.core_application.activities


import com.s10plus.core_application.R
import com.s10plus.core_application.base_ui.BaseActivity
import com.s10plus.core_application.databinding.ActivityViewBinding
import com.s10plus.core_application.models.ViewS10Plus
import com.s10plus.core_application.ui.FactoryUI
import com.s10plus.core_application.utils.JsonUtil

class ViewActivity : BaseActivity<ActivityViewBinding>(R.layout.activity_view) {

    lateinit var view:ViewS10Plus
    override fun setupView() {

        var json = intent?.getStringExtra(VIEWS10PLUS)!!
        view = JsonUtil.fromViewS10plus(json)
        setupHeader()
        setupBody()
        setupFooter()
    }

    override fun setupViewModel() {
    }

    override fun setupObserver() {
    }

    override fun setupBody() {

        view.body.layout.let {
            FactoryUI.createLayout(this,it,binding.body)

        }

    }

    override fun setupFooter() {
        view.footer.layout.let {
            FactoryUI.createLayout(this,it,binding.rootFooter)

        }

    }
    override fun init() {
    }

    companion object{
        const val VIEWS10PLUS="VIEWS10PLUS"
    }

}