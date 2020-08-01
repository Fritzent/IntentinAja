package com.example.intentinaja

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_parcelable.*

class ParcelableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parcelable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_parcel.setOnClickListener {
            val data = DataParcel(input_name_parcel.text.toString(), input_age_parcel.text.toString())
            val intent = Intent(activity, GetParcel::class.java)
            intent.putExtra("dataParcel", data)
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance(): ParcelableFragment{
            val fragment = ParcelableFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}