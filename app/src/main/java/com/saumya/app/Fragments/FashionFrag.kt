package com.saumya.app.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saumya.app.KurtiDescription.Kurtia
import com.saumya.app.KurtiDescription.Kurtib
import com.saumya.app.R
import kotlinx.android.synthetic.main.fragment_fashion.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FashionFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fashion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        clickadd.setOnClickListener {
//            Toast.makeText(context , "Item Added to Cart", Toast.LENGTH_SHORT).show()
//
//        }
        itema.setOnClickListener {
            startActivity(Intent(context, Kurtia::class.java))
        }
        itemb.setOnClickListener {
            startActivity(Intent(context, Kurtib::class.java))
        }
        clickadd1.setOnClickListener {
            startActivity(Intent(context, Kurtia::class.java))
        }
        clickadd2.setOnClickListener {
            startActivity(Intent(context, Kurtib::class.java))
        }
    }


}
