package com.example.androidtask.product

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.contracts.ProductRepositoryContract
import com.example.domain.entity.ProductsItemDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepositoryContract):ViewModel() {
    var productsList = mutableStateListOf<ProductsItemDTO>()

    fun getProductsFromRepository(){
        viewModelScope.launch() {
            try {
                val response = repository.getProducts()//...

                if (response.isNotEmpty()) {
                productsList.addAll(response)
                }
            }catch (e:Exception){
                throw e
            }
            productsList.forEach { Log.e("productList",it.toString()) }
        }
    }

}

