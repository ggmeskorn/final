package com.example.lab55

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Employee (
    @Expose
    @SerializedName("emp_firstname")val emp_firstname:String,

    @Expose
    @SerializedName("emp_lastname")val emp_lastname:String,

    @Expose
    @SerializedName("emp_gender")val emp_gender:String,

    @Expose
    @SerializedName("emp_select")val emp_select:String,

    @Expose
    @SerializedName("emp_date")val emp_date:Int,

    @Expose
    @SerializedName("emp_price")val emp_price:Int) {}