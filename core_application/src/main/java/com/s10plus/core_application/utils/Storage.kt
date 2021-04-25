package com.s10plus.core_application.utils

import android.content.Context
import com.s10plus.core_application.S10PlusApplication
import okhttp3.ResponseBody
import java.io.*

object Storage {


    private val TAG ="Storage"

    private val foldersound="sounds"
     fun writeResponseBodyToDisk(body: ResponseBody, fileName: String): Boolean {

             S10PlusApplication.currentApplication.
             openFileOutput(fileName, Context.MODE_PRIVATE).apply {
                 write(body.bytes())
                 close()
             }
         return true
    }
    fun loadJsonInitial(){

    }

}