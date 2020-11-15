package com.example.lab55

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.emp_item_layout.view.*
import java.text.DecimalFormat

class EmployeeAdapter (val item : List<Employee>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvFirstname?.text= "FirstName: "+item[position].emp_firstname
        holder.tvlastname?.text= "LastName: "+item[position].emp_lastname
        holder.tvGender?.text="Gender: "+ item[position].emp_gender
        holder.tvSelect?.text="Select: "+ item[position].emp_select
        holder.tvDate?.text="Date: "+ item[position].emp_date
        holder.tvPrice?.text="Price: " + DecimalFormat("#.###").format((item[position].emp_select.toString().toInt()*item[position].emp_date.toString().toInt()))+ "Bath"

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.emp_item_layout,parent,false)
        return ViewHolder(view_item )

    }

    override fun getItemCount(): Int {
        return item.size
    }

}


class ViewHolder (view: View): RecyclerView.ViewHolder(view){
    val tvFirstname = view.tv_first
    val tvlastname = view.tv_last
    val tvGender = view.tv_Gender
    val tvSelect = view.tv_Select
    val tvDate = view.tv_date
    val tvPrice = view.tv_price
}