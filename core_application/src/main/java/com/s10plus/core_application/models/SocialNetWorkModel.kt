package com.s10plus.core_application.models


import com.s10plus.core_application.R
import java.util.ArrayList

class SocialNetWorkModel(    var nombre: String? = null,
                             var url: String? = null,
                             var imgId :Int= 0) {

    companion object {

        fun getListMenu(): List<SocialNetWorkModel> {
            val list: MutableList<SocialNetWorkModel> = ArrayList(10)
            list.add(SocialNetWorkModel("FACEBOOK", "https://www.facebook.com/exismexico", R.drawable.ic_facebook_color))
            list.add(SocialNetWorkModel("TWITTER", "https://twitter.com/exis_mx", R.drawable.ic_twitter))
            list.add(SocialNetWorkModel("INSTAGRAM", "https://www.instagram.com/exis_mx/", R.drawable.ic_instagram))

            return list
        }
    }

}