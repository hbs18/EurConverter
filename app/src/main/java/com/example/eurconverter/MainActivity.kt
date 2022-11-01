package com.example.eurconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.google.android.material.color.DynamicColors
import com.google.android.material.elevation.SurfaceColors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // md3 status bar theming stuff
        val color = SurfaceColors.SURFACE_2.getColor(this)
        window.statusBarColor = color // Set color of system statusBar same as ActionBar
        window.navigationBarColor = color // Set color of system navigationBar same as BottomNavigationView
        // end md3 status bar theming stuff

        var conversionRate = 7.53

        var euroPriceLabel = findViewById<TextView>(R.id.euroPriceLabel)
        var hrkPriceEntryField = findViewById<EditText>(R.id.hrkPriceEntryField)

        hrkPriceEntryField.doOnTextChanged{ text, start, count, after ->
            if (hrkPriceEntryField.text != null){
                try {
                    euroPriceLabel.text = roundNumber(convertPrice(hrkPriceEntryField.text.toString().toDouble(), conversionRate))
                }
                catch (e : Exception){
                    euroPriceLabel.text = "Cijena u HRK"
                }

            }
            else {
                euroPriceLabel.text = "Cijena u HRK"
            }
        }



    }

    fun convertPrice(inputPrice : Double, conversionRate : Double) : Double {
        var outputPrice = inputPrice*conversionRate
        return outputPrice
    }

    fun roundNumber(input : Double): String{
        return "%.2f".format(input)
    }
}