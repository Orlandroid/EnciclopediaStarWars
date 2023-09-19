package com.example.androidbase.presentation.ui.productos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbase.databinding.ItemProductBinding
import com.example.androidbase.domain.entities.remote.products.Product
import com.example.androidbase.presentation.extensions.click
import com.example.androidbase.presentation.extensions.loadImage


class ProductsAdapter(private val clickOnProduct: (Product) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private var listOfCategories: List<Product> = arrayListOf()

    fun setData(lista: List<Product>) {
        listOfCategories = lista
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) = with(binding) {
            binding.root.click {
                clickOnProduct(product)
            }
            itemImage.loadImage(product.images[0])
            itemTitle.text = product.title
            itemPrice.text = product.price.toString()
            itemRating.text = product.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfCategories[position])
    }

    override fun getItemCount(): Int {
        return listOfCategories.size
    }


}
