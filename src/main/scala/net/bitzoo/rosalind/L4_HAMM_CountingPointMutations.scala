package net.bitzoo.rosalind

object CountingPointMutations {

  /**
   * Given two DNA strings of equal length, 
   * return the Hamming distance, i.e. the number of 
   * corresponding symbols that differ between the two strings
   */
  def getAnswer(fileName: String): Int = {
    val dnaStrings = Util.getListOfStringsFromFile(fileName)
    var hammingDistance = 0

    for (i <- 0 to dnaStrings(0).length - 1) {
      if (dnaStrings(0).charAt(i) != dnaStrings(1).charAt(i)) hammingDistance += 1
    }

    hammingDistance
  }

}