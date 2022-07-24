package com.mahmood.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datepicker.setOnClickListener { view ->
            clickDatePicker(view)

        }


    }


    private fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->

              val selectedDate= "$dayofMonth/${month+1}/$year"
               dob.setText(selectedDate)

                val sdf= SimpleDateFormat("dd/mm/yy",Locale.ENGLISH)  //The java.text.SimpleDateFormat class provides methods to format and parse date and time in java

                val dob= sdf.parse(selectedDate)   // it is in millisecond

               // program to calculate age in days
                val dobIndays= dob.time/86400000
                val currentDate= sdf.parse(sdf.format(System.currentTimeMillis())) // it is in millisecond
                val currentDateInDays=currentDate!!.time/86400000
                val differenceInDays= currentDateInDays-dobIndays
                age_in_day.setText(differenceInDays.toString())



                //program to calculate age in month

                val dobInMonth=dob.time/2629800000
                val currentDateInMonth= currentDate!!.time/2629800000
                val differenceInMonth= currentDateInMonth-dobInMonth
                age_in_month.setText(differenceInMonth.toString())


                //program to calculate age in year
                val dobInYear=dob.time/31536000000
                val currentDateInYear= currentDate!!.time/31536000000
                val differenceInYear= currentDateInYear-dobInYear
                age_in_year.setText(differenceInYear.toString())


                //program to calculate age in hour
                val dobInHour=dob.time/3600000
                val currentDateInHour= currentDate!!.time/3600000
                val differenceInHour= currentDateInHour-dobInHour
                age_in_hour.setText(differenceInHour.toString())


                //program to calculate age in minute
                val dobInMinute=dob.time/ 60000
                val currentDateInMinute= currentDate!!.time/ 60000
                val differenceInMinute= currentDateInMinute-dobInMinute
                age_in_minute.setText(differenceInMinute.toString())



                //program to calculate age in seconds
                val dobInseconds=dob.time/ 60000
                val currentDateInSeconds= currentDate!!.time/ 60000
                val differenceInSeconds= currentDateInSeconds-dobInseconds
                age_in_second.setText(differenceInMinute.toString())

            },
            year,
            month,
            day).show()

    }
}
