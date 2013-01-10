package net.bitzoo.rosalind

object IntroToProbability {

  def main(args: Array[String]): Unit = {

    val inputString = "0.23 0.31 0.75"
    val inputString2 = "0.000 0.060 0.144 0.171 0.235 0.254 0.322 0.351 0.437 0.467 0.524 0.578 0.604 0.661 0.740 0.776 0.812 0.891 0.928 1.000"
    val inputArray = inputString2.split(" ")
    var gcProbabilityArray = List[BigDecimal]()
    var atProbabilityArray = List[BigDecimal]()
    var probTwoSymbolsSameArray = List[BigDecimal]()

    for (num <- inputArray) {
      val n = BigDecimal(num)
      val probg = n / 2
      val probt = (1 - n) / 2
      probTwoSymbolsSameArray = (probg * probg + probt * probt) * 2 :: probTwoSymbolsSameArray
    }

    Console.println(probTwoSymbolsSameArray.reverse.mkString(" "))

  }

}