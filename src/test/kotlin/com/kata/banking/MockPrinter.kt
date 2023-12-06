class MockPrinter : ForPrinting {
    var printCalled: Int = 0
    var balanceLines: List<Int> = emptyList()

    override fun print(balances: List<Int>?): String {
        printCalled++
        if (balances != null) {
            balanceLines = balances
        }

        return ""
    }
}
