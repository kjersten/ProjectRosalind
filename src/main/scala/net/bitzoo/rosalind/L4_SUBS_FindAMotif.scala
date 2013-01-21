package net.bitzoo.rosalind

object FindAMotif {

  /**
   * Given two DNA strings, the first longer than the second, 
   * return all locations of the second string within the first string.
   * For each location, list only its beginning position.
   */
  def getAnswer(bigString: String, smallString: String): List[Int] = {
    var idx = 0
    var indices = List[Int]()

    while (idx < bigString.length() && idx != -1) {
      val loc = bigString.indexOfSlice(smallString, idx)
      if (loc != -1) {
        indices = loc + 1 :: indices
        idx = loc + 1
      } else idx = loc
    }

    // must reverse the order of the list because items are prepended rather than appended
    indices.reverse
  }

}