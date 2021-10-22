package com.example.mvpv2

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
        @GET("posts")
        fun getData(): Call<ArrayList<MyDataItem>>
    }