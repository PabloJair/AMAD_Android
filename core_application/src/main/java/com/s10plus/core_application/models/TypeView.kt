package com.s10plus.core_application.models

import com.google.gson.annotations.SerializedName

enum class TypeView {
    @SerializedName("content-box")
    CONTENTBOX,
    @SerializedName("LINEAL")
    LINEAL,
    @SerializedName("GRID")
    GRID,
    @SerializedName("HORIZONTAL")
    HORIZONTAL,
    @SerializedName("")
    NONE,
}