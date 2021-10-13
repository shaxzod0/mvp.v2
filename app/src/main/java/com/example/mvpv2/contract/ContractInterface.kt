package com.example.mvp.contract

interface ContractInterface {
    interface View{
        fun initView()
        fun updateViewData()
    }
    interface Presenter{
        fun incrementValue()
        fun increaseValue()
        fun getCounter():String
    }
    interface Model{
        fun getCounter():Int
        fun incrementCounter()
        fun increaseCounter()
    }
}