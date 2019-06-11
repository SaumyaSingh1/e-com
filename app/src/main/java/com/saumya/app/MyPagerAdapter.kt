package com.saumya.app

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter

class MyPagerAdapter (val framentlist : ArrayList<Fragment> , val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){
    override fun getItem(p0: Int): Fragment {

        return framentlist.get(p0)

    }

    override fun getCount(): Int {

       return framentlist.size
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when(position){0->return "Fashion"
            1-> return "Health"
            2->return "Electronic"
            3->return "Webdev"
            else-> return ""
        }
    }

}