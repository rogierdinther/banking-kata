package com.kata.banking

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import FakePrinter

/*
Date: 0-10
Amount: 11-17
Balance: 18-25
 */

internal class AccountTest {
    @Test
    fun `prints empty statement when no transactions were made`() {
        val account = Account()
        assertEquals(
            """|Date         Amount   Balance
               |-                 -         -""".trimMargin("|"),
            account.printStatement())
    }

    @Test
    fun `when account holder deposits, balance is value after transaction`() {
        val printer = FakePrinter()
        val account = Account(printer)
        account.deposit(500)

        val result = account.printStatement()

        val row = result.split("\n")[1]
        val balance = row.substring(22, 29)
        assertEquals("    500", balance)
        assertEquals(500, printer.balanceLines[0])
    }

//    @Test
//    fun `when a deposit was previously done, the balance in the second deposit is the balance afterwards`() {
//        val account = Account()
//        account.deposit(500)
//        account.deposit(300)

//        val result = account.printStatement()

//        val row = result.split("\n")[2]
//        val balance = row.substring(22, 29)
//        assertEquals("    800", balance)
//    }
}