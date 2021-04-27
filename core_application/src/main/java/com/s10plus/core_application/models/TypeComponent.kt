package com.s10plus.core_application.models

import com.google.gson.annotations.SerializedName

enum class TypeComponent {
    @SerializedName("BUTTON")
    BUTTON,
    @SerializedName("BUTTON_IMAGE")
    BUTTON_IMAGE,
    @SerializedName("TEXTVIEW")
    TEXTVIEW,
    @SerializedName("LABEL")
    LABEL,
    @SerializedName("CARRUSEL")
    CARRUSEL,
    @SerializedName("IMAGE")
    IMAGE,
    @SerializedName("MENU")
    MENU,
    @SerializedName("MENU_ITEM")
    MENU_ITEM,

    @SerializedName("REDES_SOCIALES")
    REDES_SOCIALES,

    @SerializedName("NONE")
    NONE
}