package com.example.gpmass.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gpmass.databinding.ItemListBinding
import com.example.gpmass.listener.ClickListener
import com.example.gpmass.room.entities.NoteEntity

class NotesAdapter(private val items: List<NoteEntity>,
                   private val listener: ClickListener
): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            listener.onClickCard(items[position])
        }
    }

    inner class ViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteEntity) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}