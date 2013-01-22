package net.bitzoo.rosalind

object InfermRnaFromProtein {
  
  // a cache of the number of possible RNA codons for each amino acid
   private var numOptions = Map[Char, BigInt]()

  /**
   * Given a protein string of at most 1,000 amino acids,
   * return the total number of different RNA strings from which
   * the protein could have been translated, modulo 1,000,000.
   */
  def getAnswer(protein: String): BigInt = {
    var listNumOptions = List[BigInt]()

    for (aa <- protein) {
      listNumOptions = findNumOptionsForAA(aa) :: listNumOptions
    }

    // add the number of options for encoding "STOP"
    listNumOptions = 3 :: listNumOptions

    val numPossibleRnaStrings: BigInt = listNumOptions.reduce((a, b) => a * b)

    numPossibleRnaStrings.mod(BigInt(1000000))
  }

  /**
   * Given an amino acid, find the number of RNA codons that might have encoded it
   */
  def findNumOptionsForAA(aa: Char): BigInt = {
    var answer = BigInt(0)

    if (!numOptions.get(aa).isEmpty) {
      answer = numOptions.get(aa).get
    } else {
      val numOptsForThisChar = Util.rnaCodonTable.filter(a => a._2 == aa).size
      numOptions = numOptions + (aa -> numOptsForThisChar)
      answer = numOptsForThisChar
    }

    answer
  }

}