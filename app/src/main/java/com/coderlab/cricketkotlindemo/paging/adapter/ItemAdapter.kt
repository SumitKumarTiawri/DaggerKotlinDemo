package com.coderlab.cricketkotlindemo.paging.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.coderlab.cricketkotlindemo.R
import com.coderlab.cricketkotlindemo.databinding.ItemPagingListBinding
import com.coderlab.cricketkotlindemo.paging.model.Item


class ItemAdapter internal constructor(private val mCtx: Context) :
    PagedListAdapter<Item, ItemAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemPagingListBinding>(
            LayoutInflater.from(mCtx),
            R.layout.item_paging_list,
            parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.item = item
    }

    inner class ItemViewHolder(val binding: ItemPagingListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.question_id == newItem.question_id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}