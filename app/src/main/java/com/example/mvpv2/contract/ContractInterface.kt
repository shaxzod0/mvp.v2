package com.example.mvpv2.contract

interface ContractInterface {
    interface View{
        fun initView()
        fun updateViewData()
    }
    interface Presenter{
        fun incrementValue()
        fun increaseValue()
        fun resetValue()
        fun getCounter():String
        fun plusTen()
    }
    interface Model{
        fun getCounter():Int
        fun resetCounter()
        fun incrementCounter()
        fun increaseCounter()
        fun plusTen()
    }
}