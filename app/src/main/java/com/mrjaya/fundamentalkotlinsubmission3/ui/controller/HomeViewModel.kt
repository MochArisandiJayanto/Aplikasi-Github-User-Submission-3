package com.mrjaya.fundamentalkotlinsubmission3.ui.controller

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrjaya.fundamentalkotlinsubmission3.api.ApiConfig
import com.mrjaya.fundamentalkotlinsubmission3.model.ItemsItem
import com.mrjaya.fundamentalkotlinsubmission3.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val listUser = MutableLiveData<ArrayList<ItemsItem>>()

    fun findUsers(query: String) {
        val client = ApiConfig.getApiService().getSearchUsers(query)
        client.enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    listUser.postValue(response.body()?.items as ArrayList<ItemsItem>?)
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getSearchUsers(): LiveData<ArrayList<ItemsItem>> {
        return listUser
    }
}