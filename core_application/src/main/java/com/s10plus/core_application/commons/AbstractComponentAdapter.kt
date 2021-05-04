package com.s10plus.core_application.commons

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.s10plus.core_application.models.*
import com.s10plus.core_application.models.TypeComponent.*
import com.s10plus.core_application.ui.LinearLayoutS10Plus
import java.lang.reflect.Type


class AbstractComponentAdapter:JsonDeserializer<AbstractComponentModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): AbstractComponentModel {

        val jsonObject = json!!.asJsonObject
        val type = valueOf(jsonObject["typeComponent"].asString)
        var component:AbstractComponentModel = when(type){

            BUTTON -> {
                context!!.deserialize(json,ButtonModel::class.java)
            }
            TEXTVIEW -> context!!.deserialize(json,TextViewModel::class.java)
            LABEL -> context!!.deserialize(json,ButtonModel::class.java)
            CARRUSEL -> context!!.deserialize(json,ButtonModel::class.java)
            IMAGE -> context!!.deserialize(json,ImageModel::class.java)
            MENU -> context!!.deserialize(json,ButtonModel::class.java)
            MENU_ITEM -> context!!.deserialize(json,ButtonModel::class.java)
            NONE -> context!!.deserialize(json,ButtonModel::class.java)
            BUTTON_IMAGE -> context!!.deserialize(json,ButtonModel::class.java)
            REDES_SOCIALES -> context!!.deserialize(json,ButtonNSModel::class.java)
        }

        component.typeComponent = type
        return component

    }
}