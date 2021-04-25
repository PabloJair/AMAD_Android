package com.s10plus.core_application.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class HeaderModel(var layout: @RawValue AbstractLayoutModel=LinealLayoutModel(),
                       var id_action:String="",
                       var order: Int=0):
    Parcelable

