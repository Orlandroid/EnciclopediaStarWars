package com.example.androidbase.presentation.ui.example

import android.util.Log
import androidx.fragment.app.viewModels
import com.example.androidbase.R
import com.example.androidbase.databinding.FragmentExampleBinding
import com.example.androidbase.presentation.base.BaseFragment
import com.example.androidbase.presentation.extensions.observeApiResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleFragment : BaseFragment<FragmentExampleBinding>(R.layout.fragment_example) {


    private val viewModel: ExampleViewModel by viewModels()

    override fun setUpUi() {

    }

    override fun observerViewModel() {
        super.observerViewModel()
        observeApiResult(viewModel.getHomeContentResponse) {
            Log.w("Android","Succes")
            it.contents.forEach {
                Log.w("Value", it.liked)
            }
        }
    }

}