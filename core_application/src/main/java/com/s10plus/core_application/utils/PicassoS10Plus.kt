package com.s10plus.core_application.utils

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.util.Log
import com.squareup.picasso.LruCache
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.RequestTransformer
import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class PicassoS10Plus {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: Picasso? = null
        fun getInstance(context: Context): Picasso? {
            if (instance == null) {

                val requestTransformer =
                    RequestTransformer { request ->
                        Log.d("image request", request.toString())
                        request
                    }
                instance = Picasso.Builder(context)
                    .downloader(OkHttp3Downloader(getUnsafeOkHttpClient()!!))
                    .memoryCache(LruCache(getBytesForMemCache(12, context)))
                    .requestTransformer(requestTransformer)
                    .listener { picasso, uri, exception ->
                        Log.d("image load error", uri.getPath());
                    }
                    .build().apply {

                        isLoggingEnabled = true
                    }


            }
            return instance
        }

        private fun getBytesForMemCache(percent: Int, context: Context): Int {
            val mi = ActivityManager.MemoryInfo()

            val activityManager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager?
            activityManager!!.getMemoryInfo(mi)
            val availableMemory = mi.availMem.toDouble()
            return (percent * availableMemory / 100).toInt()
        }

        private fun getUnsafeOkHttpClient(): OkHttpClient? {
            return try {
                // Create a trust manager that does not validate certificate chains
                val trustAllCerts = arrayOf<TrustManager>(
                    object : X509TrustManager {
                        override fun checkClientTrusted(
                            chain: Array<X509Certificate?>?,
                            authType: String?
                        ) {
                        }

                        override fun checkServerTrusted(
                            chain: Array<X509Certificate?>?,
                            authType: String?
                        ) {
                        }

                        override fun getAcceptedIssuers(): Array<X509Certificate?> {
                            return arrayOf()
                        }
                    }
                )

                // Install the all-trusting trust manager
                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())

                // Create an ssl socket factory with our all-trusting manager
                val sslSocketFactory = sslContext.socketFactory
                val builder: OkHttpClient.Builder = OkHttpClient.Builder()
                builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                builder.hostnameVerifier { hostname, session -> true }
                builder.build()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }

    }

}