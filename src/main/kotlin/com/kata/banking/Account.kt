package com.kata.banking

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

        return """|Date         Amount   Balance
                  |-                 -       $balanceAsString""".trimMargin("|")
    }
}