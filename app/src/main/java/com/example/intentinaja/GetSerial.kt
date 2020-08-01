package com.example.intentinaja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentinaja.databinding.ActivityGetSerialBinding

class GetSerial : AppCompatActivity() {

    private lateinit var binding: ActivityGetSerialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetSerialBinding.inflate(layoutInflater)
        val viewing = binding.root
        setContentView(viewing)

        val objSerial = intent.getSerializableExtra("dataSerial") as PersonData?

        if (objSerial != null){
            binding.intentTexting.setText(R.string.btn_serializable)

            binding.valueNameSerial.text = objSerial.name
            binding.valueAgeSerial.text = objSerial.age
        }else{
            binding.intentTexting.setText(R.string.txt_not_found)
        }
    }
}