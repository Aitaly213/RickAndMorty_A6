package com.example.rickandmorty.ui

import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.api.CartoonApiService
import com.example.rickandmorty.data.models.BaseResponse
import com.example.rickandmorty.data.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CartoonRepository @Inject constructor(
    private val api :CartoonApiService
){
    private val data = MutableLiveData<BaseResponse>()

    fun getCharacters() :MutableLiveData<BaseResponse>{
        api.fetchCharacters()
            .enqueue(object :
                Callback<BaseResponse> {
                override fun onResponse(p0: Call<BaseResponse>, response: Response<BaseResponse>) {
                    data.value = response.body()
                }

                override fun onFailure(p0: Call<BaseResponse>, p1: Throwable) {
                    p1.printStackTrace()
                }

            })
        return data
    }

}