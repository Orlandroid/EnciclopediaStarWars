package com.example.androidbase.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidbase.data.di.CoroutineDispatchers
import com.example.androidbase.data.remote.login.LoginRepository
import com.example.androidbase.domain.entities.remote.login.LoginRequest
import com.example.androidbase.domain.entities.remote.login.LoginResponse
import com.example.androidbase.domain.state.Result
import com.example.androidbase.presentation.base.BaseViewModel
import com.example.androidbase.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private val _loginResponse = MutableLiveData<Result<LoginResponse>>()
    val loginResponse: LiveData<Result<LoginResponse>>
        get() = _loginResponse

    fun login(body: LoginRequest) {
        viewModelScope.launch {
            safeApiCall(_loginResponse, coroutineDispatchers) {
                val response = repository.login(body)
                withContext(Dispatchers.Main) {
                    _loginResponse.value = Result.Success(response)
                }
            }
        }
    }

}