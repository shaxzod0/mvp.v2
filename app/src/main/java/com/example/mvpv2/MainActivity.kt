package com.example.mvpv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp.contract.ContractInterface
import com.example.mvp.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractInterface.View {
    private var presenter: MainActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
    }
    override fun initView() {
        counterTextView.text = presenter?.getCounter()
        clickButton.setOnClickListener { presenter?.incrementValue() }
        btn2.setOnClickListener { presenter?.increaseValue() }
    }
    override fun updateViewData() {
        counterTextView.text = presenter?.getCounter()
    }
}