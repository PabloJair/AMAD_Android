package com.s10plus.core_application.analytics

import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.models.AnalyticsModel
import io.reactivex.functions.Consumer

class AnalyticsViewModel:BaseViewModel() {
    private var service = serverRetrofit.getService(AnalyticsService::class.java)

    companion object{
        var onSendAnalytics:((analytics: AnalyticsModel)->Unit)? = null

    }
    fun sendClicks(id:String,other_information:String ){



        setupSubscribe(service.sendClick(RQ = RequestAnalytics(id,other_information)),
            {
                loader.value = false

                if (it.status == 200)
                    success.value = it.data
                else
                    error.value = it.message

            },
            {
                loader.value = false
                error.value="Las credenciales son invalidas"

            })

    }

}