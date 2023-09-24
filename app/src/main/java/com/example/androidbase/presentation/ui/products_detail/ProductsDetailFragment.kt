package com.example.androidbase.presentation.ui.products_detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.androidbase.R
import com.example.androidbase.databinding.FragmentProductsDetailBinding
import com.example.androidbase.domain.entities.remote.products.Product
import com.example.androidbase.presentation.base.BaseFragment
import com.example.androidbase.presentation.extensions.fromJson
import com.example.androidbase.presentation.extensions.observeApiResult
import com.example.androidbase.presentation.ui.MainActivity
import com.example.androidbase.presentation.ui.productos.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

@AndroidEntryPoint
class ProductsDetailFragment :
    BaseFragment<FragmentProductsDetailBinding>(R.layout.fragment_products_detail) {

    private val viewModel: ProductsViewModel by viewModels()
    private val args: ProductsDetailFragmentArgs by navArgs()
    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.detalle_product)
    )

    override fun setUpUi() {
        binding.skeletonLayout.showSkeleton()
        viewModel.getSingleProduct(args.product.fromJson<Product>().id)
    }

    override fun observerViewModel() {
        super.observerViewModel()
        observeApiResult(
            viewModel.singleProductResponse,
            haveTheViewProgress = false,
            shouldCloseTheViewOnApiError = true,
            onFinishLoading = {
                binding.skeletonLayout.showOriginal()
            }) {
            bind(it)
        }
    }

    private fun bind(product: Product) = with(binding) {
        itemTitle.text = product.title
        itemPrice.text = product.price.toString()
        itemRating.text = product.rating.toString()
        tvDescription.text = product.description
        carousel.setData(getImagesCarrousel(product))
    }

    private fun getImagesCarrousel(product: Product): List<CarouselItem> {
        val imagesCarousel = mutableListOf<CarouselItem>()
        product.images.forEach {
            imagesCarousel.add(
                CarouselItem(
                    imageUrl = it
                )
            )
        }
        return imagesCarousel
    }

}