package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    companion object {
        private val mShoeList by lazy { ShoeManager.loadShoes() }
    }

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        initShoeList()
    }

    private fun initShoeList() {
        _shoeList.value = mShoeList
    }

    fun addShoe(shoe: Shoe?) =
        shoe?.let {
            mShoeList.add(it)
            _shoeList.value = mShoeList
        }
}
