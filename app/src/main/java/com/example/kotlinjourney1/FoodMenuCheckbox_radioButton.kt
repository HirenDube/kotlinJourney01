package com.example.kotlinjourney1

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class FoodMenuCheckbox_radioButton : AppCompatActivity() {
var bill : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_menu_checkbox_radio_button)

        val pizzaView : ImageView = findViewById(R.id.pizzaImage)
        val pizzaSelection : CheckBox = findViewById(R.id.pizza)
        val pastaView : ImageView = findViewById(R.id.pastaImage)
        val pastaSelection : CheckBox = findViewById(R.id.pasta)
        val sandwichView : ImageView = findViewById(R.id.sandwichImage)
        val sandwichSelection : CheckBox = findViewById(R.id.sandwich)
        val burgerView : ImageView = findViewById(R.id.burgerImage)
        val burgerSelection : CheckBox = findViewById(R.id.burger)
        val colddrinkView : ImageView = findViewById(R.id.colddrinkImage)
        val billGenerator : Button = findViewById(R.id.billCreator)
        val colddrinkSelection : RadioGroup = findViewById(R.id.colddrinkSelection)
        lateinit var choosenColddrink : RadioButton
        colddrinkSelection.setOnCheckedChangeListener { group, checkedId ->
             choosenColddrink  = findViewById(checkedId)

        }

        Picasso.get().load("https://png.pngtree.com/png-clipart/20230412/original/pngtree-modern-kitchen-food-boxed-cheese-lunch-pizza-png-image_9048155.png").into(pizzaView)
        Picasso.get().load("https://media.istockphoto.com/id/1282339368/photo/italian-pasta-with-tomato-sauce-and-basil-leaves-isolated.jpg?s=612x612&w=0&k=20&c=D0YD3adULUybRAnQAmZJD1BQb61kh9HeNjoQW-r4Tz0=").into(pastaView)
        Picasso.get().load("https://media.istockphoto.com/id/655123574/photo/soft-drinks-splashing.jpg?s=612x612&w=0&k=20&c=iZcaMSEuzxLRy2lpnUw9NhnTcOhYNgxA3poBbjCsSSc=").into(colddrinkView)
        Picasso.get().load("https://media.istockphoto.com/id/157431311/photo/turkey-sandwich.jpg?s=612x612&w=0&k=20&c=uB6byErFAnWxFkkAqMiGNRJGE8r3nqsSDdqrfBE8HOA=").into(sandwichView)
        Picasso.get().load("https://img.freepik.com/free-vector/isolated-delicious-hamburger-cartoon_1308-134213.jpg").into(burgerView)

        billGenerator.setOnClickListener {
            bill=0
            if(pizzaSelection.isChecked){
                bill += 130
            }
            if(pastaSelection.isChecked){
                bill += 60
            }
            if(sandwichSelection.isChecked){
                bill += 210
            }
            if(burgerSelection.isChecked){
                bill += 80
            }
            try {
                if (choosenColddrink.isChecked){
                    if(choosenColddrink.text == "Coca Cola 20 /-"){
                        bill += 20
                    }else{
                        bill += 30
                    }
                }
            }catch (e:Exception){}finally {
                findViewById<TextView?>(R.id.displayBill).text = "Total Amount You Have To Pay Is : $bill"

            }

        }
    }
}