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
    private val printer = FakePrinter()

    @Test
    fun `calls print when user prints statements without any transactions`() {
        val account = Account(printer)
        account.printStatement()

        assertEquals(1, printer.printCalled)
    }

    @Test
    fun `when account holder deposits, balance is value after transaction`() {
        val account = Account(printer)
        account.deposit(500)

        account.printStatement()

        assertEquals(500, printer.balanceLines[0])
    }

   @Test
   fun `when a deposit was previously done, the balance in the second printed line is the balance afterwards`() {
       val account = Account(printer)
       account.deposit(500)
       account.deposit(300)

       account.printStatement()

       assertEquals(800, printer.balanceLines[1])
   }

   @Test
   fun `when a deposit and a subsequent withdrawal were done, the balance in the second printed line is the balance afterwards`() {
        assertEquals(true, false)
   }
}