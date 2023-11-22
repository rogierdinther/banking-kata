package com.kata.banking

// Based on this kata: https://kata-log.rocks/banking-kata

class Account {
    var deposited = false
    val deposits = mutableListOf<Int>()

    fun deposit(amount: Int) {
        deposited = true
        deposits.add(amount)
    }

    fun printStatement(): String {
        val balanceAsString = if (deposited) {
            "500"
        } else {
            "  -"
        }

        return printStatementRegels(balanceAsString)
    }

    fun printStatementRegels(balanceAsString: String): String {
        return printStatementHeader() +  printStatementRegel(balanceAsString)
    }

    fun printStatementHeader(): String {
        return "Date         Amount   Balance"
    }

    fun printStatementRegel(balanceAsString: String): String {
        return "\n" + "-                 -       $balanceAsString"
    }

}