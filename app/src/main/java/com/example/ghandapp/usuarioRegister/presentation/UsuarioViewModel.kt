package com.example.ghandapp.usuarioRegister.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ghandapp.login.data.domain.LoginUseCase
import com.example.ghandapp.usuarioRegister.presentation.model.UsuarioViewState
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class UsuarioViewModel: ViewModel() {

    private val viewState = MutableLiveData<UsuarioViewState>()
    val state: LiveData<UsuarioViewState> = viewState

    private val usecase by lazy { LoginUseCase() }
    fun validateInputs(username: String, name: String, password: String) {



        viewState.value = UsuarioViewState.showLoading


        if (username.isNullOrBlank() && password.isNullOrBlank() && name.isNullOrBlank()) {
            viewState.value = UsuarioViewState.showInvalidInputs
            return
        }

        if (name.isNullOrBlank()) {
            viewState.value = UsuarioViewState.nameInvalidMessage
            return
        }

        if (password.isNullOrBlank()) {
            viewState.value = UsuarioViewState.passwordInvalidMessage
            return
        }

        fetchCreate(username = username, name = name, password = password)
    }

    private fun fetchCreate(username: String, name: String, password: String) {
        viewModelScope.launch {
            val isCreated = usecase.createUser(username, name, password)



        }
    }
}