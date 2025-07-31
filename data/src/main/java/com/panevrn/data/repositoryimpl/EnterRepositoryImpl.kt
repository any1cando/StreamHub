package com.panevrn.data.repositoryimpl

import com.google.gson.Gson
import com.panevrn.data.dto.LoginRequestDto
import com.panevrn.data.dto.LoginResponseDto
import com.panevrn.data.mapper.LoginResponseMapper
import com.panevrn.data.network.EnterApi
import com.panevrn.domain.model.LoginResult
import com.panevrn.domain.repository.EnterRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class EnterRepositoryImpl @Inject constructor(
    private val enterApi: EnterApi,
    private val gson: Gson,
    private val mapper: LoginResponseMapper
): EnterRepository {
    override suspend fun login(email: String, password: String): Result<LoginResult> {
        return try {
            val dto = enterApi.login(LoginRequestDto(email, password))

            val result: LoginResult = mapper.map(dto)

            Result.success(result)

        } catch (error: IOException) {
            // если какие-то проблемы с сетью
            Result.failure(IOException("Проверьте интернет‑соединение", error))

        } catch (error: HttpException) {
            // четырехсотки/пятисотки, читаем тело ошибки
            val code = error.code()
            val msg = error.response()?.errorBody()?.string()
            Result.failure(RuntimeException("HTTP $code: $msg", error))

        } catch (e: Exception) {
            Result.failure(e)
        }

    }
}