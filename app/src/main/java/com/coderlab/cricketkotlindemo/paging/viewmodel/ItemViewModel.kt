package com.coderlab.cricketkotlindemo.paging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.coderlab.cricketkotlindemo.paging.model.Item


class ItemViewModel : ViewModel() {

    //creating livedata for PagedList  and PagedKeyedDataSource
    internal var itemPagedList: LiveData<PagedList<Item>>
    internal var liveDataSource: LiveData<PageKeyedDataSource<Int, Item>>

    //constructor
    init {
        //getting our data source factory
        val itemDataSourceFactory = ItemDataSourceFactory()

        //getting the live data source from data source factory
        liveDataSource = itemDataSourceFactory.itemLiveDataSource

        //Getting PagedList config
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ItemDataSource.PAGE_SIZE).build()

        //Building the paged list
        itemPagedList = LivePagedListBuilder(itemDataSourceFactory, pagedListConfig)
            .build()
    }
}