package com.example.mvpv2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpv2.R
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        btn_order.setOnClickListener {
            onBackPressed()
        }
    }
}