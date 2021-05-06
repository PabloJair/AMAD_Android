package com.s10plus.core_application.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.s10plus.core_application.models.*
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewS10Plus(
        @SerializedName("body")
        var body: BodyModel = BodyModel(),
        @SerializedName("footer")
        var footer: FooterModel = FooterModel(),
        @SerializedName("header")
        var header: HeaderModel = HeaderModel(),
        @SerializedName("id")
        var id: String = "",
        @SerializedName("typeView")
        var typeView: TypeView=TypeView.NONE,
        @SerializedName("nameView")
        var nameView: TypeView=TypeView.NONE,
        @SerializedName("order")
        var order: Int=0,
        @SerializedName("start")
        var start: Boolean=false
): Parcelable

