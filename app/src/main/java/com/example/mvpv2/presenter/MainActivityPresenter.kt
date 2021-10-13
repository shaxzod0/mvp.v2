package com.example.mvp.presenter

import com.example.mvp.contract.ContractInterface
import com.example.mvp.model.MainActivityModel


class MainActivityPresenter(_view: ContractInterface.View): ContractInterface.Presenter {

    private var view: ContractInterface.View = _view
    private var model: ContractInterface.Model = MainActivityModel()

    init {
        view.initView()
    }

    override fun incrementValue() {
        model.incrementCounter()
        view.updateViewData()
    }

    override fun increaseValue() {
        model.increaseCounter()
        view.updateViewData()
    }

    override fun getCounter() = model.getCounter().toString()

}