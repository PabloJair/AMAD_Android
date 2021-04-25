package com.s10plus.core_application.ui

import com.s10plus.core_application.models.AbstractComponentModel

interface ILiveCycleComponentView {


     var component:AbstractComponentModel
    fun onConfiguration()


}