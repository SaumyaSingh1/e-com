package com.saumya.app.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.saumya.app.Fragments.ElectronicsFragment
import com.saumya.app.Fragments.FashionFrag
import com.saumya.app.Fragments.HealthFragment
import com.saumya.app.Fragments.WebFragment
import com.saumya.app.MyPagerAdapter
import com.saumya.app.R
import kotlinx.android.synthetic.main.activity_showall.*

class ShowallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showall)


        val fragmentlist= arrayListOf<Fragment>()
        fragmentlist.add(FashionFrag())
        fragmentlist.add(HealthFragment())
        fragmentlist.add(ElectronicsFragment())
        fragmentlist.add(WebFragment())

        val pagerAdapter= MyPagerAdapter(fragmentlist, supportFragmentManager)
        viewpager.adapter=pagerAdapter
        tab.setupWithViewPager(viewpager)
    }
}
