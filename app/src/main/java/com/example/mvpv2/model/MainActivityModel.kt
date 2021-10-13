package com.example.mvp.model

import com.example.mvp.contract.ContractInterface

class MainActivityModel: ContractInterface.Model {

    private var mCounter = 0

    override fun getCounter() = mCounter

    override fun incrementCounter() {
        mCounter++
    }

    override fun increaseCounter() {
        mCounter--
    }
}