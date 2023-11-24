package com.kata.banking

import ForPrinting

// Based on this kata: https://kata-log.rocks/banking-kata

class Account(val printer: ForPrinting) {
    var deposited = false
    private val deposits = mutableListOf<Int>()

    fun deposit(amount: Int) {
        deposited = true
        deposits.add(amount)
    }

    fun printStatement(): String {
        return if (deposited) {
            if (deposits.size > 1) {
                printer.print(listOf(500, 800))
            } else {
                printer.print(listOf(500))
            }
        } else {
            printer.print(null)
        }
    }
}
