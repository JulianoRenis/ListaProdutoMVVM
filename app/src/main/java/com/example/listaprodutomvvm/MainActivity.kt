package com.example.listaprodutomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listaprodutomvvm.adapter.ItemAdapter
import com.example.listaprodutomvvm.databinding.ActivityMainBinding
import com.example.listaprodutomvvm.model.ItemModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter
    private val listItem : MutableList<ItemModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewItemProduto = binding.idRv
        recyclerViewItemProduto.layoutManager = LinearLayoutManager(this)
        recyclerViewItemProduto.setHasFixedSize(true)
        itemAdapter = ItemAdapter(this,listItem)
        recyclerViewItemProduto.adapter = itemAdapter

        binding.button.setOnClickListener {


            if (binding.edtTextInserir.text.toString().isEmpty()){
                binding.edtTextInserir.error = "Preencha um valor"
                return@setOnClickListener
            }
            val item = ItemModel(name = binding.edtTextInserir.text.toString(), onRemove = {itemAdapter.removeItem(it)})
            itemAdapter.addItem(item)
            binding.edtTextInserir.text!!.clear()
        }

    }

}