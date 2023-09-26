package com.example.androidbase.presentation.ui.perfil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidbase.data.di.CoroutineDispatchers
import com.example.androidbase.data.remote.users.UsersRepository
import com.example.androidbase.domain.entities.remote.users.UsersResponse
import com.example.androidbase.domain.state.Result
import com.example.androidbase.presentation.base.BaseViewModel
import com.example.androidbase.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UsersRepository,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {

    private val _getMeResponse = MutableLiveData<Result<UsersResponse>>()
    val getMeResponse: LiveData<Result<UsersResponse>>
        get() = _getMeResponse


    init {
        getMe()
    }

    private fun getMe() {
        viewModelScope.launch {
            safeApiCall(_getMeResponse, coroutineDispatchers) {
                val response = repository.getMe()
                withContext(Dispatchers.Main) {
                    _getMeResponse.value = Result.Success(response)
                }
            }
        }
    }
}