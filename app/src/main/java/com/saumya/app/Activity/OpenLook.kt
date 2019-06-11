package com.saumya.app.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.saumya.app.R
import kotlinx.android.synthetic.main.openlook.*

class OpenLook :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.openlook)

        btnnext.setOnClickListener {
            startActivity(Intent(baseContext,NavigationActivity::class.java))
        }


    }
}