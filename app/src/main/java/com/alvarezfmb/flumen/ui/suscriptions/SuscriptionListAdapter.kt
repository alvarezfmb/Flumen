package com.alvarezfmb.flumen.ui.suscriptions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alvarezfmb.flumen.databinding.SuscriptionListItemBinding
import com.alvarezfmb.flumen.domain.DataSource


class SuscriptionListAdapter : ListAdapter<DataSource, SuscriptionListAdapter.SuscriptionItemViewHolder>(SuscriptionListItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuscriptionItemViewHolder {
        return SuscriptionItemViewHolder(SuscriptionListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SuscriptionItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SuscriptionItemViewHolder(private val binding: SuscriptionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DataSource) {
            binding.suscriptionName.text = item.link
        }
    }
}


class SuscriptionListItemDiffCallback : DiffUtil.ItemCallback<DataSource>() { // TODO

    override fun areItemsTheSame(oldItem: DataSource, newItem: DataSource): Boolean {
        return false
//        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataSource, newItem: DataSource): Boolean {
        return false
//        return oldItem == newItem
    }
}