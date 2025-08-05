package com.panevrn.data.network

import com.panevrn.data.dto.request.LoginRequestDto
import com.panevrn.data.dto.response.LoginResponseDto
import com.panevrn.data.dto.request.RegisterRequestDto
import com.panevrn.data.dto.response.RegisterResponseDto
import retrofit2.http.Body
import retrofit2.http.POST


interface EnterApi {

    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequestDto): LoginResponseDto

    @POST("api/v1/auth/register")
    suspend fun register(@Body request: RegisterRequestDto): RegisterResponseDto

}