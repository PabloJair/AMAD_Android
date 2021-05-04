package com.s10plus.core_application.models

import com.google.gson.annotations.SerializedName

enum class KeyProperties {

    @SerializedName("SIZE")
    SIZE,
    @SerializedName("COLOR")
    COLOR,
    @SerializedName("TEXT")
    TEXT,

    @SerializedName("MARGIN")
    MARGIN,
    @SerializedName("PADDING")
    PADDING,
    @SerializedName("SIZE_TEXT")
    SIZE_TEXT,
    @SerializedName("BACKGROUND")
    BACKGROUND,
    @SerializedName("CORNER_RADIUS")
    CORNER_RADIUS,
    @SerializedName("URL_IMAGE")
    URL_IMAGE,
    @SerializedName("COLOR_GRADIENT")
    COLOR_GRADIENT,
    @SerializedName("ORIENTATION")
    ORIENTATION,
    @SerializedName("SEND_TO_VIEW")
    SEND_TO_VIEW,
    @SerializedName("BACK_VIEW")
    BACK_VIEW,
    @SerializedName("OPEN_URL")
    OPEN_URL,
    //VIEW.TEXT_ALIGNMENT_TEXT_END,
    @SerializedName("TEXT_ALIGNMENT")
    TEXT_ALIGNMENT,

    @SerializedName("TEXT_LINK")
    TEXT_LINK,

    @SerializedName("OPEN_URL_INTERNAL")
    OPEN_URL_INTERNAL,

    @SerializedName("FACEBOOK_URL")
    FACEBOOK_URL,

    @SerializedName("TWITTER_URL")
    TWITTER_URL,

    @SerializedName("YOUTUBE_URL")
    YOUTUBE_URL,
    @SerializedName("TEXT_HTML")
    TEXT_HTML,
}