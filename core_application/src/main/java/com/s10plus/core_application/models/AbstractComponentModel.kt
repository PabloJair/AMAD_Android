package com.s10plus.core_application.models

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.gson.annotations.Expose
import com.s10plus.core_application.GlobalSettings
import com.s10plus.core_application.S10PlusApplication
import com.s10plus.core_application.activities.ViewActivity
import com.s10plus.core_application.activities.WebViewActivity
import com.s10plus.core_application.analytics.AnalyticsViewModel.Companion.onSendAnalytics
import com.s10plus.core_application.base_ui.ActivityUtils
import com.s10plus.core_application.utils.JsonUtil
import kotlinx.android.parcel.RawValue
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess


abstract class AbstractComponentModel(
    var properties: @RawValue ArrayList<Property> = arrayListOf()
) {


    @Expose(serialize = false)
    var typeComponent: TypeComponent = TypeComponent.NONE

    @Expose(serialize = false)
    var text: String = ""
        get() = Property.getPropertyValue(properties, KeyProperties.TEXT) ?: ""

    @Expose(serialize = false)
    var textColor = ""
        get() = Property.getPropertyValue(properties, KeyProperties.COLOR) ?: "#000000"

    @Expose(serialize = false)
    var padding: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.PADDING)?.valueToIntArray(" ")

    @Expose(serialize = false)
    var size: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.SIZE)?.valueToIntArray(" ")

    @Expose(serialize = false)
    var margin: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.MARGIN)?.valueToIntArray(" ")

    @Expose(serialize = false)
    var cornerRadius: String? = null
        get() = Property.getProperty(properties, KeyProperties.CORNER_RADIUS)?.value

    @Expose(serialize = false)
    var background: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.BACKGROUND)

    @Expose(serialize = false)
    var gradientBackground: List<Int>? = null
        get() = Property.getProperty(properties, KeyProperties.COLOR_GRADIENT)
            ?.split(" ")?.map { Color.parseColor(it) }

    @Expose(serialize = false)
    private var view: View? = null

    @Expose(serialize = false)
    var sendToView: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.SEND_TO_VIEW)


    @Expose(serialize = false)
    var backView: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.BACK_VIEW)


    @Expose(serialize = false)
    var openUrl: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.OPEN_URL)

    @Expose(serialize = false)
    var openUrlInternal: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.OPEN_URL_INTERNAL)

    @Expose(serialize = false)
    var openEmail: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.OPEN_EMAIL)

    @Expose(serialize = false)
    var sendAnalytics: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.SEND_ANALYTICS)


    @Expose(serialize = false)
    var showForTime: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.SHOW_FOR_TIME)

    @Expose(serialize = false)
    var call: String? = null
        get() = Property.getPropertyValue(properties, KeyProperties.CALL)

    abstract fun onConfigView(view: View)

    open fun init(view: View) {
        this.view = view
        onPreConfiguration(view)
        onConfigView(view)
    }

    open fun realoadView() {

        this.init(this.view!!)
    }

    open fun onPreConfiguration(view: View) {


        val shape = ShapeDrawable()
        size?.let {
            if (view.layoutParams is LinearLayout.LayoutParams) {
                view.layoutParams = LinearLayout.LayoutParams(it[0], it[1])
            } else {
                view.layoutParams = ViewGroup.MarginLayoutParams(it[0], it[1])

            }
        }
        margin?.let {
            (view.layoutParams as ViewGroup.MarginLayoutParams).setMargins(
                it[0],
                it[1],
                it[2],
                it[3]
            )
        }
        padding?.let { view.setPadding(it[0], it[1], it[2], it[3]) }

        cornerRadius?.let {

            val radius = it.toFloat()
            shape.shape = RoundRectShape(
                floatArrayOf(radius, radius, radius, radius, radius, radius, radius, radius),
                null, null
            )
            view.background = shape
        }
        background?.let {
            shape.paint.color = Color.parseColor(it)
            view.background = shape
        }

        gradientBackground?.let {
            val shader = object : ShapeDrawable.ShaderFactory() {
                override fun resize(width: Int, height: Int): Shader {

                    return LinearGradient(
                        0f, 0f, 0f,
                        view.height.toFloat(),
                        it[0],
                        it[1],
                        Shader.TileMode.CLAMP
                    )
                }
            }
            shape.shaderFactory = shader
            view.background = shape

        }



        sendToView?.let {
            val viewS10Plus = GlobalSettings.getView(it)
            if (viewS10Plus != null) {
                goTo(viewS10Plus, view, sendAnalytics)
            }
        }

        backView?.let { backView(view, sendAnalytics) }


        openUrl?.let { goToUrl(it, view, sendAnalytics) }

        openUrlInternal?.let { goToUrlInternal(it, view, sendAnalytics) }
        openEmail?.let { goToEmail(it, view, sendAnalytics) }


        showForTime?.let {


            val split = it.split(" ")
            val start = split[0].toInt()
            val end = split[1].toInt()
            val condition = split[2]

            val hour: String = SimpleDateFormat("HH", Locale.US).format(Date())
            when (condition) {
                "!" -> {
                    if (hour.toInt() !in start..end) {
                        view.visibility = View.GONE

                    }
                }
                "" -> {
                    if (hour.toInt() in start..end) {
                        view.visibility = View.GONE

                    }
                }
            }

        }



        call?.let {
            continueCall(it, view, sendAnalytics)
        }


    }


    companion object {

        fun sendAnalytics(analytics: String?) {
            analytics?.let {
                if (!it.isNullOrEmpty())
                    onSendAnalytics?.invoke(AnalyticsModel.createForString(it))
            }

        }

        fun goTo(viewS10Plus: ViewS10Plus, view: View?, analytics: String?) =
            view?.setOnClickListener {
                if (!analytics.isNullOrEmpty()) sendAnalytics(analytics)
                S10PlusApplication.currentApplication.startActivity(
                    Intent(view.context, ViewActivity::class.java)
                        .putExtra(ViewActivity.VIEWS10PLUS, JsonUtil.toJson(viewS10Plus))
                )

            }


        fun backView(view: View?, analytics: String?) =
            view?.setOnClickListener {
                if (!analytics.isNullOrEmpty()) sendAnalytics(analytics)

                S10PlusApplication.getCurrentActivity().onBackPressed()

            }


        fun goToUrlInternal(url: String, view: View?, analytics: String?) =
            view?.setOnClickListener {
                if (!analytics.isNullOrEmpty()) sendAnalytics(analytics)


                S10PlusApplication.currentApplication.startActivity(
                    Intent(view.context, WebViewActivity::class.java)
                        .putExtra(WebViewActivity.URL, url)
                )
            }


        fun goToUrl(url: String, view: View?, analytics: String?) =
            view?.setOnClickListener {
                if (!analytics.isNullOrEmpty()) sendAnalytics(analytics)

                ActivityUtils.openWebView(view.context, url)

            }

        fun goToEmail(url: String, view: View?, analytics: String?) =
            view?.setOnClickListener {
                if (!analytics.isNullOrEmpty()) sendAnalytics(analytics)

                ActivityUtils.openEmail(view.context, url)

            }

        fun continueCall(url: String, view: View?, analytics: String?) =
            view?.setOnClickListener {
                if (!analytics.isNullOrEmpty()) sendAnalytics(analytics)


                GlobalSettings.saveInterceptorPhone(false, GlobalSettings.getNumberPhone())
                Thread.sleep(1000)

                S10PlusApplication.currentApplication.startActivity(
                    Intent(Intent.ACTION_DIAL).setData(
                        Uri.parse("tel:" + GlobalSettings.getPhonesInterceptor().first())
                    )
                )
                (S10PlusApplication.currentApplication as Activity).finishAffinity()
                exitProcess(0)


            }
    }


}