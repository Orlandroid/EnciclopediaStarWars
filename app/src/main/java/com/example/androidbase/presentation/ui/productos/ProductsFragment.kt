package com.example.androidbase.presentation.ui.productos

import androidx.fragment.app.viewModels
import com.example.androidbase.R
import com.example.androidbase.databinding.FragmentProductsBinding
import com.example.androidbase.presentation.base.BaseFragment
import com.example.androidbase.presentation.extensions.observeApiResult
import com.example.androidbase.presentation.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>(R.layout.fragment_products) {

    private val viewModel: ProductsViewModel by viewModels()
    private val adapter = ProductsAdapter()

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.productos)
    )

    override fun configSearchView() = MainActivity.SearchViewConfig(
        showSearchView = true
    )

    override fun setUpUi() {
        viewModel.getProducts()
        binding.homeRecyclerView.adapter = adapter
        setCarousel()
    }

    private fun setCarousel() {
        val list = mutableListOf<CarouselItem>()
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.hot_sale
            )
        )
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.hot_sale2
            )
        )
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.hot_sale3
            )
        )
        binding.carousel.setData(list)
    }

    override fun observerViewModel() {
        super.observerViewModel()
        observeApiResult(viewModel.productsResponse) {
            adapter.setData(it.products)
        }
    }


}