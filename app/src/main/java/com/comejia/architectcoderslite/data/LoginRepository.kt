package com.comejia.architectcoderslite.data

class LoginRepository(
    private val remoteDataSource: LoginRemoteDataSource = LoginRemoteDataSourceImpl()
) {
    suspend fun tryLogin(user: String, pass: String): LoginResult =
        remoteDataSource.tryLogin(user, pass)
}

// Este data puede queda mejor en un archivo separado
data class LoginResult(val userError: Boolean, val passError: Boolean)

val LoginResult.success get() = !userError && !passError