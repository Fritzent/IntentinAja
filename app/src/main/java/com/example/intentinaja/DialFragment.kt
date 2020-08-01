package com.example.intentinaja

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dial.view.*

class DialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dial, container, false)

        view.btn_dial.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel: ${view.input_number.text}")
            }

            val manage = context!!.packageManager
            if (intent.resolveActivity(manage) != null) {
                startActivity(intent)
            }
        }

        return view
    }

    companion object {
        fun newInstance(): DialFragment{
            val fragment = DialFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}