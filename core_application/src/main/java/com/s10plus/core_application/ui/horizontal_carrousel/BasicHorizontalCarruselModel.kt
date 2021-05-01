package com.s10plus.core_application.ui.horizontal_carrousel

import androidx.annotation.DrawableRes

data class BasicHorizontalCarruselModel(

    var text:String ="",
    var url_Image:String="",
    @DrawableRes
    var resourceId:  Int=0

)