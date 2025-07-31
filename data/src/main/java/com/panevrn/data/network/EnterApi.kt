package com.panevrn.data.network

import com.panevrn.data.dto.LoginRequestDto
import com.panevrn.data.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST


interface EnterApi {

    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequestDto): LoginResponseDto

}