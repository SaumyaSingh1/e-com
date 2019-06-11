package com.saumya.app.KurtiDescription

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saumya.app.R
import kotlinx.android.synthetic.main.activity_kurtiaa.*

class Kurtia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kurtiaa)

        addcart.setOnClickListener {
            Toast.makeText(baseContext, "Item Addedc to your Cart", Toast.LENGTH_SHORT).show()
        }


    }
}
