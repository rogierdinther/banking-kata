package com.kata.banking

import ForPrinting
import MockPrinter
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.test.assertEquals

internal class AccountTest {
    private val printer = MockPrinter()
    private val account = Account(printer)

    @Test
    fun `when account holder made no deposits, statement printing gives no error`() {
        account.printStatement()

        assertEquals(1, printer.printCalled)
    }

    // @Test
    // TODO: Zorg dat Account het resultaat van Printer returned

    @Test
    fun `when account holder deposits, balance is value after transaction`() {
        val printerMock: ForPrinting = Mockito.mock(ForPrinting::class.java)
        Mockito.`when`(printerMock.print(Mockito.anyList())).thenReturn("Statement result")

        val mockInjectedAccount = Account(printerMock)

        mockInjectedAccount.deposit(500)
        mockInjectedAccount.printStatement()

        Mockito.verify(printerMock).print(listOf(500))
    }

    @Test
    fun `when a deposit was previously done, the balance in the second deposit is the balance afterwards`() {
        account.deposit(500)
        account.deposit(300)

        account.printStatement()

        assertEquals(800, printer.balanceLines[1])
    }

    @Test
    fun `when two deposits are done, the balance in the first deposit is the balance before the second deposit`() {
        account.deposit(100)
        account.deposit(1100)

        account.printStatement()

        assertEquals(100, printer.balanceLines[0])
    }
}
