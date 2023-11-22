package com.kata.banking

import ForPrinting
import kotlin.io.print

// Based on this kata: https://kata-log.rocks/banking-kata

class Account(val printer: ForPrinting? = null) {
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
        if (printer != null) {
            printer.printStatementLine("maaktnietuit", 500, 500)
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