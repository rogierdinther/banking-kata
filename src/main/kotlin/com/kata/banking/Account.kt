package com.kata.banking

import ForPrinting

// Based on this kata: https://kata-log.rocks/banking-kata

class Account(val printer: ForPrinting) {
    var deposited = false
    val deposits = mutableListOf<Int>()


    fun deposit(amount: Int) {
        deposited = true
        deposits.add(amount)
    }

    fun printStatement(): String {
        return if (deposited) {
            printer.print(500)
        } else {
            printer.print(null)
        }
    }

//    fun printStatementRegels(balance: Int): String {
//        return printer.createHeader() + "\n" + printer.createStatementLine("", 0, balance)
//    }
}