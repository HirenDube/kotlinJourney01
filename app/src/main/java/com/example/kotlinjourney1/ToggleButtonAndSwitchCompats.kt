package com.example.kotlinjourney1

import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class ToggleButtonAndSwitchCompats : AppCompatActivity() {
    lateinit var noramalSwitch: Switch
    lateinit var compatSwitch: SwitchCompat
    lateinit var toggle: ToggleButton
    lateinit var card1: TextView
    lateinit var card2: TextView
    lateinit var card3: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_button_and_switch_compats)

        noramalSwitch = findViewById(R.id.card2Switcher)
        compatSwitch = findViewById(R.id.card1Switcher)
        toggle = findViewById(R.id.card3Switcher)
        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)
        card3 = findViewById(R.id.card3)

        noramalSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                card2.text = "Card 2 is in Dark Mode"
            }else{
                card2.text = "Card 2 is in Light Mode"
            }
        }
        compatSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                card1.text = "Card 1 is in Dark Mode"
            }else{
                card1.text = "Card 1 is in Light Mode"
            }
        }
        toggle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                card3.text = "Card 3 is in Dark Mode"
            }else{
                card3.text = "Card 3 is in Light Mode"
            }
        }
    }
}