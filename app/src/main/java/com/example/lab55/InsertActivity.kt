package com.example.lab55

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_insert.*
import kotlinx.android.synthetic.main.activity_insert.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertActivity : AppCompatActivity() {
    var subject: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        val subjectSpinner: Spinner = spiner_subject;
        val subjectArray = resources.getStringArray(R.array.SelectSize_array)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjectArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        subjectSpinner.adapter = arrayAdapter

        subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                subject = subjectArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }
    fun onClickNext(v: View){

        val api : EmployeeAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeAPI ::class.java)

        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        var selectedId:Int = radioGroup.checkedRadioButtonId
        var radioButton: RadioButton = findViewById(selectedId)

        api.insertStd(

            firstEDT.text.toString(),
            lastEDT.text.toString(),
            radioButton.text.toString(),
            subject.toString(),
            dateEDT.text.toString().toInt()).enqueue(object : Callback<Employee> {

            override fun onResponse(call: Call<Employee>, response: retrofit2.Response<Employee>) {
                if (response.isSuccessful()){
                    Toast.makeText(applicationContext,"Successfully Inserted", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Error ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Employee>, t: Throwable) {
                Toast.makeText(applicationContext, "Error onFailure " + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    fun Cancel(v:View){

    }

}
