package com.dss.a17test.viewmodel

import MyApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dss.a17test.model.MyApiService
import com.dss.a17test.model.UserSearchResult


class HomeViewModel: ViewModel() {
//    val userSearchResult = MutableLiveData<UserSearchResult>()
//        val userSearchResult = MutableLiveData<UserSearchResult>()



    val retrofitService = MyApiService.retrofit().create(MyApi::class.java)
//    val userItems:MutableLiveData<PagedList<UserSearchResult.Item>>

    var userItems = MutableLiveData<PagedList<UserSearchResult.Item>>()
//    val userItems = usersRepository.getUserItems()




//    private val sourceFactory by lazy {
//        DataSourceFactory().create()
//    }

//    val pagingDataItems: MutableLiveData<PagedList<UserSearchResult.Item>> by lazy {
//        sourceFactory.
//    }


//
//
//
//    fun fetchAgentInfo() {
//
//        val data: HashMap<String, String> = HashMap()
//        val call = retrofitService.getTestApi("tom",30)
//        call.enqueue(object : Callback<UserSearchResult> {
//            override fun onFailure(call: Call<UserSearchResult>, t: Throwable) {
////                isLoadError.value = true
////                isloading.value = false
//
//            }
//
//            override fun onResponse(
//                call: Call<UserSearchResult>,
//                response: Response<UserSearchResult>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        userSearchResult.value = it
//
//                    }
//
//                } else {
//
//                }
//
//
//            }
//
//        })
//    }
    // TODO: Implement the ViewModel
}