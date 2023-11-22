class FakePrinter : ForPrinting {
    val balanceLines: MutableList<Int> = mutableListOf()

    override fun printStatementLine(date: String, amount: Int, balance: Int) {
        balanceLines.add(
            balance
        )
     }

}