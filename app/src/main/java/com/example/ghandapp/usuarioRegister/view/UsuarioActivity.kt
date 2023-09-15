package com.example.ghandapp.usuarioRegister.view


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ghandapp.databinding.ActivityUsuarioBinding
import com.example.ghandapp.usuarioRegister.presentation.UsuarioViewModel
import com.example.ghandapp.usuarioRegister.presentation.model.UsuarioViewState


class UsuarioActivity: AppCompatActivity() {

    private lateinit var binding: ActivityUsuarioBinding

    private val viewModel: UsuarioViewModel by viewModels();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeObserver()
    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                UsuarioViewState.isCreated -> showCreated()
                UsuarioViewState.genericErrorMessage -> showGenericMessage()
                UsuarioViewState.nameInvalidMessage -> showNameInvalidMessage()
                UsuarioViewState.showInvalidInputs -> showInvalidInputs()
                UsuarioViewState.showLoading -> showLoading()
                UsuarioViewState.passwordInvalidMessage -> showPasswordInvalidMessage()

            }
        }
    }

    private fun showPasswordInvalidMessage() {
        TODO("Not yet implemented")
    }

    private fun showLoading() {

    }

    private fun showInvalidInputs() {
        TODO("Not yet implemented")
    }

    private fun showNameInvalidMessage() {
        TODO("Not yet implemented")
    }

    private fun showGenericMessage() {
        TODO("Not yet implemented")
    }

    private fun showCreated() {
        TODO("Not yet implemented")
    }
}