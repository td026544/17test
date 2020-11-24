package com.dss.a17test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.dss.a17test.model.DataSourceFactory
import com.dss.a17test.model.UserSearchResult


class SearchResultViewModel : ViewModel() {

    lateinit var userItems: LiveData<PagedList<UserSearchResult.Item>>

    fun searchUser(name: String) {
        val sourceFactory = DataSourceFactory(name)
        val myPagingConfig = Config(
                pageSize = 30,
                prefetchDistance = 150,
                enablePlaceholders = true
        )
        userItems = sourceFactory.toLiveData(
                myPagingConfig
        )

    }


}