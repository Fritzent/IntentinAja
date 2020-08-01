package com.example.intentinaja

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_bundle.view.*


class BundleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_bundle, container, false)

        // Inflate the layout for this fragment
        view.btn_bundle.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Name", view.input_name.text.toString())
            bundle.putString("Age", view.input_age.text.toString())

            val dataBundle = Intent(view.context, GetLayout::class.java)
            dataBundle.putExtras(bundle)
            startActivity(dataBundle)
        }

        return view
    }

    companion object {
        fun newInstance(): BundleFragment{
            val fragment = BundleFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}