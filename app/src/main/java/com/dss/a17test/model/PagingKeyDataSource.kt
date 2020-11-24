package com.dss.a17test.model

import MyApi
import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.dss.a17test.model.Constants.Companion.GIT_API_PAGE_MAX_LIMIT
import com.orhanobut.logger.Logger.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class PagingKeyDataSource(val searchName:String) : PageKeyedDataSource<Int, UserSearchResult.Item>() {

    private var page = 1
    val retrofitService = MyApiService.retrofit().create(MyApi::class.java)



    override fun loadInitial(params: LoadInitialParams<Int>,
                             callback: LoadInitialCallback<Int, UserSearchResult.Item>) {
        val call = retrofitService.getTestApi(searchName,page)

        call.enqueue(object : Callback<UserSearchResult> {

            override fun onFailure(call: Call<UserSearchResult>?, t: Throwable?) { }

            override fun onResponse(call: Call<UserSearchResult>?,
                                    response: Response<UserSearchResult>
            ) {
                if(response.isSuccessful){
                   if(response.code()==200){
                       try {
                           callback.onResult(response.body()!!.items, null,
                                   page)
                       }
                       catch (e: Exception) {
                           d("Api Error")
                           // handler
                       }


                   }else{
                       d("Error:"+response.code())

                   }
                }

            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>,
                           callback: LoadCallback<Int,  UserSearchResult.Item>) {

        val call = retrofitService.getTestApi("tom",page)


        call.clone().enqueue(object : Callback<UserSearchResult> {

            override fun onFailure(call: Call<UserSearchResult>?, t: Throwable?) { }

            override fun onResponse(call: Call<UserSearchResult>?,
                                    response: Response<UserSearchResult>) {
                if(response.isSuccessful){
                    if(response.code()==200){
                        try {
                            callback.onResult(response.body()!!.items, page)
                            page += 1
                        }
                        catch (e: Exception) {
                            d("Api Error")
                            // handler
                        }


                    }else{
                        d("Error:"+response.code())

                    }
                }






            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>,
                            callback: LoadCallback<Int, UserSearchResult.Item>) { }
}