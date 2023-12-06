package com.kata.banking

import ForPrinting

// Based on this kata: https://kata-log.rocks/banking-kata

class Account(val printer: ForPrinting) {
    private val balanceList = mutableListOf<Int>()

    fun deposit(amount: Int) {
        val currentBalance = balanceList.lastOrNull() ?: 0
        balanceList.add(currentBalance + amount)
    }

    fun printStatement(): String {
        printer.print(balanceList)
        return ""
    }

//    fun printStatementRegels(balance: Int): String {
//        return printer.createHeader() + "\n" + printer.createStatementLine("", 0, balance)
//    }
}
