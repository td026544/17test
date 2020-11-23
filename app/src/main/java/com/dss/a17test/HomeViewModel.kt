package com.dss.a17test

import AppClientManager
import MyApi
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dss.a17test.model.UserSearchResult
import com.google.android.play.core.internal.ap
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel() {
    val userSearchResult = MutableLiveData<UserSearchResult>()



    val retrofitService = AppClientManager.retrofit().create(MyApi::class.java)


    fun fetchAgentInfo() {
        val data: HashMap<String, String> = HashMap()
        data["q"] = "tom"
        val call = retrofitService.getTestApi(data)
        call.enqueue(object : Callback<UserSearchResult> {
            override fun onFailure(call: Call<UserSearchResult>, t: Throwable) {
//                isLoadError.value = true
//                isloading.value = false

            }

            override fun onResponse(
                call: Call<UserSearchResult>,
                response: Response<UserSearchResult>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        userSearchResult.value = it

                    }

                } else {

                }


            }

        })
    }
    // TODO: Implement the ViewModel
}