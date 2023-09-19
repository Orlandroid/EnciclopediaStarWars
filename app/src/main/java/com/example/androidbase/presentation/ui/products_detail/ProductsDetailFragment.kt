package com.example.androidbase.presentation.ui.products_detail

import com.example.androidbase.R
import com.example.androidbase.databinding.FragmentProductsDetailBinding
import com.example.androidbase.presentation.base.BaseFragment
import com.example.androidbase.presentation.ui.MainActivity


class ProductsDetailFragment : BaseFragment<FragmentProductsDetailBinding>(R.layout.fragment_products_detail) {

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.productos)
    )

    override fun setUpUi() {

    }

}