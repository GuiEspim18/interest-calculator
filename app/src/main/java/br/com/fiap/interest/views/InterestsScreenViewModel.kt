package br.com.fiap.interest.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InterestsScreenViewModel: ViewModel() {

    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private val _tax = MutableLiveData<String>()
    val tax: LiveData<String> = _tax

    private val _period = MutableLiveData<String>()
    val period: LiveData<String> = _period

    private val _interests = MutableLiveData<Double>()
    val interests: LiveData<Double> = _interests

    private val _amount = MutableLiveData<Double>()
    val amount: LiveData<Double> = _amount


    fun onCapitalChanged(newCapital: String) {
        _capital.value = newCapital
    }

    fun onTaxChange(newTax: String) {
        _tax.value = newTax
    }

    fun onPeriodChange(newPeriod: String) {
        _period.value = newPeriod
    }

    fun calculateInterests() {
        _interests.value = br.com.fiap.interest.utils.calculateInterests(
            capital = _capital.value!!.toDouble(),
            tax = _tax.value!!.toDouble(),
            period = _period.value!!.toDouble()
        )
    }

    fun calculateAmount() {
        _amount.value = br.com.fiap.interest.utils.calculateAmount(
            capital = _capital.value!!.toDouble(),
            interests = _interests.value!!.toDouble()
        )
    }

}