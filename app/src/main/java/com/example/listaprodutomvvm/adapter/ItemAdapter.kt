package com.example.listaprodutomvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listaprodutomvvm.R
import com.example.listaprodutomvvm.databinding.ItemProdutoBinding
import com.example.listaprodutomvvm.model.ItemModel

class ItemAdapter (val context: Context,private val items: MutableList<ItemModel>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding : ItemProdutoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemModel){
          binding.txtItemAdapter.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemProdutoBinding.inflate(LayoutInflater.from(context),parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }
}