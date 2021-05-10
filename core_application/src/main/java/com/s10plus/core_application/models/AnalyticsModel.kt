package com.s10plus.core_application.models

class AnalyticsModel(
    var IdAction:String="",
    var Action:String="",
    var Activity:String="",
    var Label:String="",
    var Concept:String=""
) {


    companion object{

        fun createForString(analytics: String):AnalyticsModel{

            var array = analytics.split("|")

            return AnalyticsModel(array[0],array[1],array[2],array[3],array[4])


        }

    }

}