package com.example.intentinaja

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_serializable.view.*

class SerializableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_serializable, container, false)

        view.btn_serial.setOnClickListener {
            val data = PersonData (view.input_name.text.toString(), view.input_age.text.toString())

            val intent = Intent(view.context, GetSerial::class.java)
            intent.putExtra("dataSerial", data)
            startActivity(intent)
        }

        return view
    }

    companion object {
        fun newInstance(): SerializableFragment{
            val fragment = SerializableFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}