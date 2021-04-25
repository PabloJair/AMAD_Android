package com.s10plus.core_application.sound

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.*


interface FileService {
    @GET
    fun downloadFile(@Url fileUrl: String?): Observable<ResponseBody>
}