package com.s10plus.core_application

import android.content.Context
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.SPUtils
import com.google.gson.reflect.TypeToken
import com.s10plus.core_application.configuration.*
import com.s10plus.core_application.mocks.*
import com.s10plus.core_application.models.UserInformation
import com.s10plus.core_application.models.ViewS10Plus
import java.util.*


object GlobalSettings {


    var saveReceiverCall = true
    const val USER = "USER"
    const val SP_S10PLUS="SP_S10PLUS-AMAD"
    const val TOKEN="TOKEN"
    const val SERIAL="SERIAL"
    const val STATE="STATE"
    const val ISCONFIG="ISCONFIG"
    const val PHONES = "PHONES"
    const val LASTUPDATE = "LASTUPDATE"

     var config:Configuration =Configuration(

         preconfiguration = Preconfiguration(
             geolocation = Geolocation(active = true),
             state =  State(true),
             requestPhone = RequestPhone(active = true,
                 arrayListOf("5511620300","8005005050")),
             sound = "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/intro.mp3?alt=media&token=832e01b7-38ab-40c4-842f-85af9ea9d768"
         ),
         views = arrayListOf(BecasAmad.MenuHome(),
             BecasAmad.ViewBecasDeEducacion1(),
             BecasAmad.ViewBecasDeEducacionMedia2(),
             BecasAmad.ViewBecasDeEducacionMediaIG7(),
             *(BecasAmadMenuBienestarAzteca.all()).toTypedArray(),
             *(ViewsBJEF.all()).toTypedArray(),
             *(ViewElisa.all()).toTypedArray(),
             *(ViewsControloriasocial.all()).toTypedArray()



         )
     )


    const val SP_INTERCEPTER_PHONE="SP_INTERCEPTER_PHONE"
    const val SP_NUMBER_PHONE="SP_NUMBER_PHONE"
    const val PHONE_1="5511620300"
    const val PHONE_2="8005005050"
    const val CURRENT_PHONE="CURRENT_PHONE"
     var lat:Double=0.toDouble()
     var  lng:Double=0.0

    private var token:String?=null
    private var serial:String?=null
    private var state:Pair<String,String>?=null

    private var current_phone:String?=null

    private var userInformation:UserInformation?=null


    fun setIsConfig(isConfig:Boolean)=
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).put(ISCONFIG, isConfig)

    fun isConfig():Boolean=
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getBoolean(ISCONFIG, false)


    fun getView(id: String): ViewS10Plus? = config.views.find { it.id == id }


    fun getNumberPhone(): String {
        val np = SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getString(SP_NUMBER_PHONE)
        return if (np.isEmpty()) PHONE_1 else np

    }

    fun saveUpdateConfig() {
        val now = Calendar.getInstance()
        now.add(Calendar.MINUTE, 5)
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE)
            .put(LASTUPDATE, now.timeInMillis)

        /*var dateFormat: DateFormat = SimpleDateFormat("yyyy-mm-dd hh:mm:ss")
        var strDate = dateFormat.format(lastUpdate.time)
        strDate*/

    }

    fun validateUpdate(): Boolean {
        var cacheUpdate = SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getLong(
            LASTUPDATE
        )

        var lastUpdate = Calendar.getInstance()
        lastUpdate.timeInMillis = cacheUpdate
        return Calendar.getInstance() > lastUpdate

    }

    fun saveInterceptorPhone(isInterceptor: Boolean, phoneNumber: String = "") {
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE)
            .put(SP_INTERCEPTER_PHONE, isInterceptor)

        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE)
            .put(SP_NUMBER_PHONE, phoneNumber)

    }

    fun getToken(): String =
        if(token==null) {
            token = SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getString(TOKEN)
            token!!
        }else token!!


    fun getCurrentPhone(quitExtension: Boolean = false):String=
        if(current_phone==null|| current_phone.isNullOrEmpty()){
            current_phone = SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getString(
                CURRENT_PHONE
            )
            if(quitExtension){
            current_phone?.replace("+521", "")!!
            }else
                current_phone!!
        }else {
            if(quitExtension){
                current_phone?.replace("+521", "")!!
            }else
                current_phone!!
        }


    fun setCurrentPhone(phone: String, lada: String = "+521"){
        if(phone.isNullOrEmpty())
            return
        current_phone = if (phone.isNotEmpty()) {
            SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).put(CURRENT_PHONE, "$lada$phone")
            "$lada$phone"
        }else {
            SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).put(CURRENT_PHONE, "")
            ""
        }

    }
    fun setToken(token: String){
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).put(TOKEN, token)
        this.token = token

    }

    fun setSerial(serial: String = UUID.randomUUID().toString().substring(0, 15)){
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).put(SERIAL, serial)
        this.serial = serial
    }

    fun getPhonesInterceptor():Set<String> =
    SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getStringSet(PHONES)

    fun setPhones(phones: ArrayList<String>){
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).put(PHONES, phones.toMutableSet())

    }


    fun getSerial():String=
            if(serial==null|| serial.isNullOrEmpty()) {
                serial = SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getString(SERIAL)

                if(serial==null|| serial.isNullOrEmpty()){
                    setSerial()
                }
                serial!!

            }else {
                serial!!

            }

    fun setState(state:Pair<String,String>){
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).put(STATE, GsonUtils.toJson(state))
        this.state = state
    }


    fun getState():Pair<String,String>? =
        if(state==null) {

            val storedHashMapString: String = SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getString(STATE)
            val type = object : TypeToken<Pair<String?, String>>() {}.type
            if(storedHashMapString.isNotEmpty()) {
                val testHashMap2: Pair<String, String> =
                    GsonUtils.fromJson(storedHashMapString, type)
                state = testHashMap2


            }
            state

        }else {
            state

        }

    fun getInterceptorPhone():Boolean{
        return SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE)
            .getBoolean(SP_INTERCEPTER_PHONE)

    }

    fun getUser():UserInformation=
        if(userInformation==null) {
            SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getString(USER).let {

                GsonUtils.fromJson(it, UserInformation::class.java)

            }
        }else userInformation!!

 fun validateSession():Boolean{

     val json=SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).getString(USER)

     return if(json.isNullOrEmpty())
         false
     else {
         getUser()
         true

     }

 }

    fun closeSession(){
        SPUtils.getInstance(SP_S10PLUS, Context.MODE_PRIVATE).apply {

            remove(USER)
        }

    }
}