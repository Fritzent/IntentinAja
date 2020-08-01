package com.example.intentinaja

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_w_m.view.*

class WMFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_w_m, container, false)
//        val countryCode = countryCodePicker as CountryCodePicker

        view.btn_wm.setOnClickListener {

            if (view.input_message.text.toString().isEmpty() && view.input_number.text.isEmpty()){
                Toast.makeText(
                    context,
                    "Enter phone number and message",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
//                countryCode.registerCarrierNumberEditText(textNumber)
//                var phoneNumber = ""
//                phoneNumber = countryCode.fullNumber
                val installed = appInstalledOrNot("com.whatsapp")
                val countryCodeIndonesia = +62

                if (installed){
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(
                            "https://api.whatsapp.com/send?phone=" + countryCodeIndonesia + view.input_number.text
                                    + "&text=" + view.input_message.text.toString()
                        )
                    }
                    startActivity(intent)
                    view.input_number.setText("")
                    view.input_message.setText("")
                }else {
                    Toast.makeText(
                        context,
                        "WhatsApp not installed on your Device",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }

        return view
    }

    private fun appInstalledOrNot(uri: String): Boolean {
        val packageManager = context!!.packageManager
        val appInstaled: Boolean
        appInstaled = try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return appInstaled
    }

    companion object {
        fun newInstance(): WMFragment{
            val fragment = WMFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}