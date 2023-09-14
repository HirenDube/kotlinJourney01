package com.example.kotlinjourney1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class DateAndTimePickers : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    //defining variables to access the xml/Ui element
    lateinit var pickDate: Button
    lateinit var pickTime: Button
    lateinit var displayDate: TextView
    lateinit var displayTime: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_and_time_pickers)

        // assigned the xml elements into respective variables
        displayDate = findViewById(R.id.displayDate)
        displayTime = findViewById(R.id.displayTime)
        pickDate = findViewById<Button?>(R.id.datePicker)
        pickTime = findViewById<Button?>(R.id.timePicker)

        //Calendar object created to get current date & time
        val now: Calendar = Calendar.getInstance()

        // opening Date picker on button click
        pickDate.setOnClickListener {
            displayDate.text = "nothings Happening now"
            DatePickerDialog(
                this,
                android.R.style.Theme_Material_Light_Dialog_Alert,
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
        }

        // opening Time picker on button click
        pickTime.setOnClickListener {
            TimePickerDialog(this,this,now.get(Calendar.HOUR),now.get(Calendar.MINUTE),false)
            displayTime.text = "!!!! Nothings happening here either !!!!"
        }


    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        displayDate.text = "$dayOfMonth / ${month+1} / $year"
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        displayTime.text = "$hourOfDay : $minute"
    }
}