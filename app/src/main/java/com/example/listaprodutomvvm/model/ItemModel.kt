package com.example.listaprodutomvvm.model

data class ItemModel(
    val name: String,
    val onRemove: (ItemModel) -> Unit
)
