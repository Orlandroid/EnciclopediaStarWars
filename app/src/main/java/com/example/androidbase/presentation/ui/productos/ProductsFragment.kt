package com.example.androidbase.presentation.ui.productos

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidbase.R
import com.example.androidbase.databinding.FragmentProductsBinding
import com.example.androidbase.domain.entities.remote.products.Product
import com.example.androidbase.presentation.base.BaseFragment
import com.example.androidbase.presentation.extensions.gone
import com.example.androidbase.presentation.extensions.observeApiResult
import com.example.androidbase.presentation.extensions.toJson
import com.example.androidbase.presentation.extensions.visible
import com.example.androidbase.presentation.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>(R.layout.fragment_products) {

    private val viewModel: ProductsViewModel by viewModels()
    private val adapter = ProductsAdapter(clickOnProduct = { clickOnProduct(it) })
    private val products = arrayListOf<Product>()

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true, toolbarTitle = getString(R.string.productos)
    )

    override fun configSearchView() =
        MainActivity.SearchViewConfig(
            showSearchView = true,
            onQueryTextSubmit = {
                onTextQuery(it)
            },
            onQueryTextChange = {
                if (it.isEmpty()) {
                    binding.tvNoData.gone()
                    adapter.setData(products)
                }
            }
        )

    override fun setUpUi() {
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

    private fun clickOnProduct(product: Product) {
        findNavController().navigate(
            ProductsFragmentDirections.actionProductsFragmentToProductsDetailFragment(
                product = product.toJson()
            )
        )
    }

    private fun onTextQuery(query: String) {
        if (query.isEmpty()) {
            adapter.setData(products)
            return
        }
        val queryProducts = products.filter {
            it.title.uppercase().contains(query.uppercase())
        }
        if (queryProducts.isEmpty()) {
            adapter.setData(emptyList())
            binding.tvNoData.visible()
            return
        }
        binding.tvNoData.gone()
        adapter.setData(queryProducts)
    }

    override fun observerViewModel() {
        super.observerViewModel()
        observeApiResult(viewModel.productsResponse) {
            products.clear()
            products.addAll(it.products)
            adapter.setData(products)
        }
    }


}