package com.comejia.architectcoderslite.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface LoginRemoteDataSource {
    suspend fun tryLogin(user: String, pass: String): LoginResult
}

class LoginRemoteDataSourceImpl : LoginRemoteDataSource {

    override suspend fun tryLogin(user: String, pass: String): LoginResult {
        return withContext(Dispatchers.IO) {
            delay(2000)
            val userError = !user.contains('@')
            val passError = pass.length < 5

            LoginResult(userError, passError)
        }
    }
}