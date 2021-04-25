package com.s10plus.core_application.commons

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.s10plus.core_application.models.*
import com.s10plus.core_application.models.TypeView.*
import com.s10plus.core_application.ui.LinearLayoutS10Plus
import java.lang.reflect.Type


class AbstractLayoutAdapter:JsonDeserializer<AbstractLayoutModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): AbstractLayoutModel {

        val jsonObject = json!!.asJsonObject
        val type = valueOf(jsonObject["typeView"].asString)
        val layout:AbstractLayoutModel = when(type){
            CONTENTBOX -> TODO()
            LINEAL -> context!!.deserialize(json,LinealLayoutModel::class.java)
            GRID -> TODO()
            HORIZONTAL -> TODO()
            NONE -> context!!.deserialize(json,LinealLayoutModel::class.java)

        }

        layout.typeView = type
            return layout
    }
}