package com.saumya.app.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.saumya.app.R
import kotlinx.android.synthetic.main.activity_deals.*

class DealsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deals)
        giftcard.setOnClickListener {
            startActivity(Intent(baseContext, OfferActivity::class.java))
        }

    }
}
