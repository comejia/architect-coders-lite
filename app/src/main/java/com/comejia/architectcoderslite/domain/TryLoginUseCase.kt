package com.comejia.architectcoderslite.domain

import com.comejia.architectcoderslite.data.LoginRepository
import com.comejia.architectcoderslite.data.LoginResult

class TryLoginUseCase(
    private val loginRepository: LoginRepository = LoginRepository()
) {

    // Se usa operator para que no usar el metodo "invoke"
    suspend operator fun invoke(user: String, pass: String): LoginResult =
        loginRepository.tryLogin(user, pass)
}

// Nota: los uses cases no deberian almacenar datos