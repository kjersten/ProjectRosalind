package net.bitzoo.rosalind

object ConsensusAndProfile {

  private val bases = List('A', 'C', 'G', 'T')

  /**
   * Given a list of no more than 10 DNA strings,
   * return a consensus string and a profile matrix for the collection
   */
  def getAnswer(fileName: String): Tuple2[Map[Char, Array[Int]], Array[Char]] = {
    val dnaStrings = Util.getListOfStringsFromFile(fileName)
    val profile = getProfile(dnaStrings)
    val consensus = getConsensus(profile, dnaStrings.first.length)
    
    (profile, consensus)
  }

  /**
   * For a list of DNA strings, all of equal length,
   * return a profile matrix.  A profile matrix is a matrix encoding 
   * the number of times that each symbol of the alphabet occurs 
   * in each position from a collection of strings.
   */
  def getProfile(dnaStrings: List[String]): Map[Char, Array[Int]] = {
    val profile = getInitialProfileMap(dnaStrings.first.length)

    for (dnaString <- dnaStrings) {
      for (i <- 0 to dnaString.size - 1) {
        val aa = dnaString(i)
        val profilesForAA = profile.get(aa).get
        profilesForAA(i) = profilesForAA(i) + 1
      }
    }

    profile
  }

  /** 
   * Return a map where each base pair has an empty array of integers, 
   * one integer place for each base pair in the DNA string.
   * For example, the map would look like this if the DNA string had 5 base pairs:
   * A: 0 0 0 0 0 
   * C: 0 0 0 0 0
   * G: 0 0 0 0 0
   * T: 0 0 0 0 0
   */
  def getInitialProfileMap(numBasePairsInDnaString: Int): Map[Char, Array[Int]] = {
    var profile = Map[Char, Array[Int]]()

    // the map should have an int list for each base pair
    bases.foreach(x => profile = profile + (x -> Array.ofDim[Int](numBasePairsInDnaString)))

    // return the map
    profile
  }

  /**
   * Given a profile matrix, return the consensus.
   * The consensus is an array of the most common symbol at each position.
   * If any position has more than one most common symbol, choose a winner
   * arbitrarily.  Project Rosalind doesn't care which you choose.
   */
  def getConsensus(profile: Map[Char, Array[Int]], arrayLength: Int): Array[Char] = {
    val consensus = Array.ofDim[Char](arrayLength)
    
    for (i <- 0 to consensus.size - 1) {
      // if a and b are equal, b will win... Rosalind does not require all possibilities
      val mostCommon = profile.reduceLeft((a, b) => if (a._2(i) > b._2(i)) a else b)
      consensus(i) = mostCommon._1
    }

    consensus
  }

}