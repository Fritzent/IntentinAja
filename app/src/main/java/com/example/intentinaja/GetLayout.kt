package com.example.intentinaja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentinaja.databinding.ActivityGetLayoutBinding

class GetLayout : AppCompatActivity() {

    private lateinit var bindingData: ActivityGetLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingData = ActivityGetLayoutBinding.inflate(layoutInflater)
        val viewing = bindingData.root
        setContentView(viewing)

        if (intent.extras != null){
            bindingData.intentTexting.setText(R.string.btn_bundle)
            bindingData.valueName.text = intent.getStringExtra("Name")
            bindingData.valueAge.text = intent.getStringExtra("Age")
        }else {
            bindingData.intentTexting.setText(R.string.txt_not_found)
        }
    }
}