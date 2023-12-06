package com.kata.banking

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import MockPrinter

/*
Date: 0-10
Amount: 11-17
Balance: 18-25
 */

internal class AccountTest {
    private val printer = MockPrinter()
    private val account = Account(printer)

    @Test
    fun `when account holder made no deposits, statement printing gives no error`() {
        account.printStatement()

        assertEquals(1, printer.printCalled)
    }

    @Test
    fun `when account holder deposits, balance is value after transaction`() {
        account.deposit(500)

        account.printStatement()

        assertEquals(500, printer.balanceLines[0])
    }

    @Test
    fun `when a deposit was previously done, the balance in the second deposit is the balance afterwards`() {
        account.deposit(500)
        account.deposit(300)

        val result = account.printStatement()

        assertEquals(800, printer.balanceLines[1])
    }
}
