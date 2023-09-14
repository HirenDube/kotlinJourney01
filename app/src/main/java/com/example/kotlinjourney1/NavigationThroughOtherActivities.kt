package com.example.kotlinjourney1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NavigationThroughOtherActivities : AppCompatActivity() {
    lateinit var _3layouts : TextView
    lateinit var _dateAndTimePickers : TextView
    lateinit var _foodmenu : TextView
    lateinit var _onOffSwitches : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_through_other_activities)
        _3layouts = findViewById(R.id._3layouts)
        _3layouts.setOnClickListener{
            var intent : Intent = Intent(this@NavigationThroughOtherActivities,LinearLayout::class.java)
            startActivity(intent)
        }
        _foodmenu = findViewById(R.id._foodMenu)
        _foodmenu.setOnClickListener{
            var intent : Intent = Intent(this@NavigationThroughOtherActivities,FoodMenuCheckbox_radioButton::class.java)
            startActivity(intent)
        }
        _onOffSwitches = findViewById(R.id._onOffSwitches)
        _onOffSwitches.setOnClickListener{
            var intent : Intent = Intent(this@NavigationThroughOtherActivities,ToggleButtonAndSwitchCompats::class.java)
            startActivity(intent)
        }
        _dateAndTimePickers = findViewById(R.id._datepicker)
        _dateAndTimePickers.setOnClickListener{
            var intent : Intent = Intent(this@NavigationThroughOtherActivities,DateAndTimePickers::class.java)
            startActivity(intent)
        }
    }
}