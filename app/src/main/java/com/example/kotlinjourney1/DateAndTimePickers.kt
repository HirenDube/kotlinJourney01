package com.example.kotlinjourney1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class DateAndTimePickers : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    //defining variables to access the xml/Ui element
    lateinit var pickDate: Button
    lateinit var pickTime: Button
    lateinit var displayDate: TextView
    lateinit var displayTime: TextView
    lateinit var dropdownMenu: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_and_time_pickers)

        // assigned the xml elements into respective variables
        displayDate = findViewById(R.id.displayDate)
        displayTime = findViewById(R.id.displayTime)
        pickDate = findViewById(R.id.datePicker)
        pickTime = findViewById(R.id.timePicker)
        dropdownMenu = findViewById(R.id.spinner)

        //Calendar object created to get current date & time
        val now: Calendar = Calendar.getInstance()

        // opening Date picker on button click
        pickDate.setOnClickListener {
            displayDate.text = "nothings Happening now"

            DatePickerDialog(
                this@DateAndTimePickers, this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            ).show()

//            DatePickerDialog(
//                this,
//                android.R.style.Theme_Material_Light_Dialog_Alert,
//                this,
//                now.get(Calendar.YEAR),
//                now.get(Calendar.MONTH),
//                now.get(Calendar.DAY_OF_MONTH)
//            )
        }

        // opening Time picker on button click
        pickTime.setOnClickListener {
//            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  },now.get(Calendar.HOUR),now.get(Calendar.MINUTE),false)
            displayTime.text = "!!!! Nothings happening here either !!!!"
            TimePickerDialog(
                this,
                 object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                        displayTime.text = "$hourOfDay : $minute"
                    }
                },
                now.get(Calendar.HOUR),
                now.get(Calendar.MINUTE),false
            ).show()
        }

        var animes: Array<String> = arrayOf("Naruto", "Demon Slayer", "Jujutsu Kaisen", "Attack on Titan", "Food Wars", "One Piece", "Dragon Ball", "Bleach")

        dropdownMenu.adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, animes)
        dropdownMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@DateAndTimePickers, "You selected : " + animes[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@DateAndTimePickers, "Nothing is selected", Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        displayDate.text = "$dayOfMonth / ${month + 1} / $year"
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        displayTime.text = "$hourOfDay : $minute"
    }
}