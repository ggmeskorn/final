package com.example.lab55

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface EmployeeAPI {
    @GET("allemp")
    fun retrieveStudent(): Call<List<Employee>>

    @FormUrlEncoded
    @POST("emp")
    fun insertStd(
        @Field("emp_firstname") emp_fistname :String,
        @Field("emp_lastname") emp_lastname :String,
        @Field("emp_gender") emp_gender :String,
        @Field("emp_select") emp_select :String,
        @Field("emp_date") emp_date :Int) : Call<Employee>
}