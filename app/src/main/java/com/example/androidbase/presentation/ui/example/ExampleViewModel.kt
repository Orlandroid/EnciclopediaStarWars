package com.example.androidbase.presentation.ui.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidbase.data.di.CoroutineDispatchers
import com.example.androidbase.data.remote.products.ProductsRepository
import com.example.androidbase.domain.state.Result
import com.example.androidbase.presentation.base.BaseViewModel
import com.example.androidbase.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val repository: ProductsRepository,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {

    private val _getHomeContentResponse = MutableLiveData<Result<FeaturedContent>>()
    val getHomeContentResponse: LiveData<Result<FeaturedContent>>
        get() = _getHomeContentResponse

    init {
        getHomeContent()
    }

    private fun getHomeContent() {
        viewModelScope.launch {
            safeApiCall(_getHomeContentResponse, coroutineDispatchers) {
                val response = repository.getHomeContent()
                withContext(Dispatchers.Main) {
                    _getHomeContentResponse.value = Result.Success(response)
                }
            }
        }
    }

}