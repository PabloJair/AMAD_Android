package com.s10plus.core_application.sound

import android.util.Log
import com.s10plus.core_application.base_ui.BaseViewModel
import com.s10plus.core_application.utils.Storage

class FileViewModel: BaseViewModel() {

    private  val TAG ="FileViewModel"
    private var service = serverRetrofit.getClientNoUnsafe(FileService::class.java)


    fun getFile(url:String){
        setupSubscribe(service.downloadFile(url), {
            Storage.writeResponseBodyToDisk(it,"sound.mp3");
            Log.d(TAG,"OK")

        },{
            Log.d(TAG,"OK")

        })

    }

}