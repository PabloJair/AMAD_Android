package com.s10plus.core_application.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class FooterModel(var layout: @RawValue AbstractLayoutModel=LinealLayoutModel(),
                  var id_action:String="",
                  var order: Int=0):
    Parcelable

