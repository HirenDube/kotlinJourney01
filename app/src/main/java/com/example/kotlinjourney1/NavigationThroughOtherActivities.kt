package com.example.kotlinjourney1

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class NavigationThroughOtherActivities : AppCompatActivity() {

    lateinit var _grid: GridView
    override fun onCreate(savedInstanceState: Bundle?) {

        var listOfPages: List<String> = listOf(
            "Signin, Sigup & profile Pages with 3 base layouts",
            "Food menu using Checkboxes and radio buttons",
            "Toggle button and Switch + Switch Compat practice",
            "Date and Time Pickers on Button Click and The spinner AKA Dropdownmenu",
        )

        var listOfActivities: List<Intent> =
            listOf(
                Intent(this@NavigationThroughOtherActivities, LinearLayout::class.java),
                Intent(this@NavigationThroughOtherActivities, FoodMenuCheckbox_radioButton::class.java),
                Intent(this@NavigationThroughOtherActivities, ToggleButtonAndSwitchCompats::class.java),
                Intent(this@NavigationThroughOtherActivities, DateAndTimePickers::class.java),
            )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_through_other_activities)
//        _3layouts = findViewById(R.id._3layouts)
//        _3layouts.setOnClickListener {
//            var intent: Intent = Intent(this@NavigationThroughOtherActivities, LinearLayout::class.java)
//            startActivity(intent)
//        }
//        _foodmenu = findViewById(R.id._foodMenu)
//        _foodmenu.setOnClickListener {
//            var intent: Intent = Intent(this@NavigationThroughOtherActivities, FoodMenuCheckbox_radioButton::class.java)
//            startActivity(intent)
//        }
//        _onOffSwitches = findViewById(R.id._onOffSwitches)
//        _onOffSwitches.setOnClickListener {
//            var intent: Intent = Intent(this@NavigationThroughOtherActivities, ToggleButtonAndSwitchCompats::class.java)
//            startActivity(intent)
//        }
//        _dateAndTimePickers = findViewById(R.id._datepicker)
//        _dateAndTimePickers.setOnClickListener {
//            var intent: Intent = Intent(this@NavigationThroughOtherActivities, DateAndTimePickers::class.java)
//            startActivity(intent)
//        }
        _grid = findViewById(R.id.navigatorGrid)
        _grid.adapter = NavigatingGridAdapter(this, listOfPages,listOfActivities)
        _grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            startActivity(listOfActivities[position])
        }


    }
}