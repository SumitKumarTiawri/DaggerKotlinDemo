package com.coderlab.cricketkotlindemo.paging.viewmodel

import androidx.paging.PageKeyedDataSource
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.DataSource.Factory
import com.coderlab.cricketkotlindemo.paging.model.Item


class ItemDataSourceFactory : Factory<Int, Item>() {
    //creating the mutable live data
    //getter for itemlivedatasource
    val itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Item>>()

    override fun create(): DataSource<Int, Item> {
        //getting our data source object
        val itemDataSource = ItemDataSource()

        //posting the datasource to get the values
        itemLiveDataSource.postValue(itemDataSource)

        //returning the datasource
        return itemDataSource
    }
}