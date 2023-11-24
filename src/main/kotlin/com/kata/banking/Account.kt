package com.kata.banking

import ForPrinting
import ForDepositingMoney

// Based on this kata: https://kata-log.rocks/banking-kata

class Account(val printer: ForPrinting) : ForDepositingMoney {
    var deposited = false
    private val balances = mutableListOf<Int>()

    override fun deposit(amount: Int) {
        deposited = true
        val previousBalance =
                if (balances.isEmpty()) {
                    0
                } else {
                    balances[balances.size - 1]
                }
        balances.add(amount + previousBalance)
    }

    fun printStatement(): String {
        return if (deposited) {
            printer.print(balances)
        } else {
            printer.print(balances)
        }
    }
}
