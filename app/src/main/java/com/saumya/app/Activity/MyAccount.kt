package com.saumya.app.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.saumya.app.R
import kotlinx.android.synthetic.main.activity_my_account.*

class MyAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        additem.setOnClickListener {
            startActivity(Intent(baseContext, ShowallActivity::class.java))
        }
    }
}
