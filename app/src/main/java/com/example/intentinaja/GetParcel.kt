package com.example.intentinaja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentinaja.databinding.ActivityGetParcelBinding

class GetParcel : AppCompatActivity() {

    private lateinit var binding: ActivityGetParcelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetParcelBinding.inflate(layoutInflater)
        val viewing = binding.root
        setContentView(viewing)

        val objData = intent.getParcelableExtra("dataParcel") as DataParcel?
        if (objData != null){
            binding.intentTexting.setText(R.string.btn_parcel)

            binding.valueNameParcel.text = objData.name
            binding.valueAgeParcel.text = objData.age
        }else{
            binding.intentTexting.setText(R.string.txt_not_found)
        }
    }
}