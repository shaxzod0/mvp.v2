package com.example.mvp.model

import com.example.mvpv2.contract.ContractInterface

class MainActivityModel: ContractInterface.Model {

    private var mCounter = 0


    override fun getCounter() = mCounter

    override fun resetCounter() {
        mCounter -= mCounter
    }
    override fun incrementCounter() {
        mCounter++
    }

    override fun increaseCounter() {
        mCounter--
    }

    override fun plusTen() {
        mCounter+=10
    }
}