package com.example.androidbase.presentation.ui.login

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.example.androidbase.R
import com.example.androidbase.databinding.FragmentLoginBinding
import com.example.androidbase.domain.entities.remote.login.LoginErrorResponse
import com.example.androidbase.domain.entities.remote.login.LoginRequest
import com.example.androidbase.presentation.base.BaseFragment
import com.example.androidbase.presentation.extensions.click
import com.example.androidbase.presentation.extensions.fromJson
import com.example.androidbase.presentation.extensions.observeApiResult
import com.example.androidbase.presentation.extensions.obtainText
import com.example.androidbase.presentation.extensions.onTextChanged
import com.example.androidbase.presentation.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels()
    override fun setUpUi() {
        binding.buttonLogin.click {
            viewModel.login(getBodyLogin())
        }
        binding.edEmailormobileLogin.onTextChanged { caneEnableButton() }
        binding.edPasswordLogin.onTextChanged { caneEnableButton() }
    }

    override fun observerViewModel() {
        super.observerViewModel()
        observeApiResult(viewModel.loginResponse,
            onError = {
                it.fromJson<LoginErrorResponse>().let { reponse ->
                    if (reponse.message == "Invalid credentials") {
                        requireContext().showToast("Credenciales invalidas")
                    }
                }
            }
        ) {
            requireContext().showToast("Bienbenido al sistema")
        }
    }

    private fun getBodyLogin(): LoginRequest {
        val user = binding.edEmailormobileLogin.obtainText()
        val password = binding.edPasswordLogin.obtainText()
        return LoginRequest(username = user, password = password)
    }

    private fun caneEnableButton() {
        binding.buttonLogin.isEnabled = !areEmptyTheFields()
    }

    private fun areEmptyTheFields(): Boolean {
        if (binding.edEmailormobileLogin.obtainText().isEmpty()) return true
        if (binding.edPasswordLogin.obtainText().isEmpty()) return true
        return false
    }


}