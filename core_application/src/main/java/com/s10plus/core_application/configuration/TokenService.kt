package com.s10plus.core_application.configuration

import com.s10plus.core_application.models.BaseModel
import com.s10plus.core_application.models.TokenRequestModel
import com.s10plus.core_application.network.EndPoints
import io.reactivex.Observable
import retrofit2.http.*

interface TokenService {


    @POST(EndPoints.LOAD)
    fun load(@Body mainRequest: TokenRequestModel=TokenRequestModel()): Observable<BaseModel<Any>>



}