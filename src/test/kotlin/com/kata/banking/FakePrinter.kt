class FakePrinter : ForPrinting {
    var printCalled: Int = 0
    val balanceLines: MutableList<Int> = mutableListOf()

    override fun print(balance: Int?): String {
        printCalled++
        if (balance != null) {
            balanceLines.add(balance)
        }

        return ""
    }
}