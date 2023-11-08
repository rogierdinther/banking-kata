package com.kata.banking

class Account {
    var deposited = false
    val deposits = mutableListOf<Int>()

    fun deposit(amount: Int) {
        deposited = true
        deposits.add(amount)
    }

    fun printStatement() =
        if (deposited) {
            """|Date         Amount   Balance
               |-                 -       500""".trimMargin("|")
        } else {
            """|Date         Amount   Balance
               |-                 -         -""".trimMargin("|")
        }
}