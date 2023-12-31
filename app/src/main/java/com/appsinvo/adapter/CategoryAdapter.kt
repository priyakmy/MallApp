package com.appsinvo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.appsinvo.api.data.Category
import com.appsinvo.databinding.ItemCategoryBinding

class CategoryAdapter(private val onClick:(String,Int) ->Unit) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(DiffCallBack()) {


    private class DiffCallBack : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.binding.item = (getItem(position))
        holder.binding.ivIcon.background =
            ContextCompat.getDrawable(holder.binding.ivIcon.context, getItem(position).icon)
        holder.binding.root.setOnClickListener {
            onClick.invoke(getItem(position).name,getItem(position).icon)
        }
    }

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) : ViewHolder(binding.root)
}


