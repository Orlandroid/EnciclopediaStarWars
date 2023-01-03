package com.example.androidbase.presentation.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidbase.data.Repository
import com.example.androidbase.data.di.CoroutineDispatchers
import com.example.androidbase.domain.entities.remote.PeopleResponse
import com.example.androidbase.domain.state.Result
import com.example.androidbase.presentation.base.BaseViewModel
import com.example.androidbase.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: Repository,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private val _userResponse = MutableLiveData<Result<PeopleResponse>>()
    val userResponse: LiveData<Result<PeopleResponse>>
        get() = _userResponse

    fun getUsers() {
        viewModelScope.launch {
            safeApiCall(_userResponse, coroutineDispatchers) {
                val response = repository.getPeople()
                withContext(Dispatchers.Main) {
                    _userResponse.value = Result.Success(response)
                }
            }
        }
    }

}