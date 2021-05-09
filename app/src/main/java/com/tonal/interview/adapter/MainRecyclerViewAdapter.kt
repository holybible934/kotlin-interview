package com.tonal.interview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tonal.interview.R
import com.tonal.interview.data.Movement

class MainRecyclerViewAdapter:
    ListAdapter<Movement, MainRecyclerViewAdapter.MovementViewHolder>(MovementDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementViewHolder {
        return MovementViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movement,
                parent,
                false
            )
        )
    }

    inner class MovementViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Movement?) {
            with(view) {
                name.text = item?.name ?: ""

            }
        }

    }

    override fun onBindViewHolder(holder: MovementViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MovementDiff : DiffUtil.ItemCallback<Movement>() {
    override fun areItemsTheSame(oldItem: Movement, newItem: Movement): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movement, newItem: Movement): Boolean {
        return oldItem.name == newItem.name
    }
}
