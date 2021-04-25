package com.s10plus.core_application.models

 data class Property(val  key:KeyProperties=KeyProperties.COLOR, val value :String=""){

  fun split(delimiter:String):List<String> = this.value.split(delimiter)
  fun valueToIntArray(delimiter:String):List<Int> = split(delimiter).map { it.toInt() }

  companion object{
   fun getPropertyValue(properties: ArrayList<Property> ,key:KeyProperties):String?{

    return  getProperty(properties,key)?.value
   }
   fun getProperty(properties: ArrayList<Property> ,key:KeyProperties):Property?{

    return  properties.find { it.key == key }
   }
  }
 }
