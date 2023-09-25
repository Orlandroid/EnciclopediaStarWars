package com.example.androidbase.presentation.ui.perfil

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbase.R
import com.example.androidbase.databinding.ItemPerfilBinding
import com.example.androidbase.presentation.extensions.click

class ProfileAdapter(private val clickOnMenu: (ProfileItem) -> Unit) :
    RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    private var listProfileItem: List<ProfileItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<ProfileItem>) {
        listProfileItem = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemPerfilBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: ProfileItem) {
            binding.root.click {
                clickOnMenu(menu)
            }
            binding.title.text = menu.name
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemPerfilBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(listProfileItem[position])


    override fun getItemCount() = listProfileItem.size

    data class ProfileItem(
        val name: String,
        val image: Int = R.drawable.perfil
    )

}
