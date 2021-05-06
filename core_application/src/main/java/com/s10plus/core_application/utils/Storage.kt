package com.s10plus.core_application.utils

import android.content.Context
import com.s10plus.core_application.S10PlusApplication
import okhttp3.ResponseBody
import java.io.*

object Storage {


    private val TAG ="Storage"
    val nameConfig ="config.json"


     fun writeResponseBodyToDisk(body: ResponseBody, fileName: String): Boolean {

             S10PlusApplication.currentApplication.
             openFileOutput(fileName, Context.MODE_PRIVATE).apply {

                 write(body.bytes())
                 close()

             }
         return true
    }

    fun writeToDisk(byteArray: ByteArray, fileName: String): Boolean {

        S10PlusApplication.currentApplication.
        openFileOutput(fileName, Context.MODE_PRIVATE).apply {
            write(byteArray)
            close()

        }
        return true
    }
    fun existFile(nameFile: String):Boolean{
       return S10PlusApplication.currentApplication.getFileStreamPath(nameFile).exists()
    }

    fun getFileText(nameFile: String):String{
        var file = S10PlusApplication.currentApplication.getFileStreamPath(nameFile)
        val fr = FileReader(file)
        return  fr.readText()


    }
}