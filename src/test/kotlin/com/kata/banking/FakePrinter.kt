class FakePrinter : ForPrinting {
    var printCalled: Int = 0
    val balanceLines: MutableList<Int> = mutableListOf()

    override fun print(balances: List<Int>): String {
        printCalled++
        if (printCalled > 1) {
            throw Exception()
        }

        for (balance in balances) {
            balanceLines.add(balance)
        }

        return ""
    }
}
