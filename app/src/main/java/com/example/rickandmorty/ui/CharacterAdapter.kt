package com.example.rickandmorty.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.models.Character
import com.example.rickandmorty.databinding.ItemCharacterBinding

class Adaptr:ListAdapter<Character,Adaptr.ViewHolder>(DiffUtilCallback()) {

    class ViewHolder(private val binding: ItemCharacterBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            Glide.with(binding.root.context)
                .load(character.image)
                .into(binding.ivCharacter)
            binding.tvName.text = character.name
            binding.tvStatus.text = character.status
            binding.tvSpecies.text = character.species
            binding.tvLocation.text = character.location.name
            binding.tvCreated.text = character.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffUtilCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

}
