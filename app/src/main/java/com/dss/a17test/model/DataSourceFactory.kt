package com.dss.a17test.model

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class DataSourceFactory (val searchName:String): DataSource.Factory<Int, UserSearchResult.Item>() {

    private val sourceLiveData = MutableLiveData<PagingKeyDataSource>()

    override fun create(): DataSource<Int, UserSearchResult.Item> {

        val source = PagingKeyDataSource(searchName)
        sourceLiveData.postValue(source)
        return source
    }
}