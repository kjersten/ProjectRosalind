package net.bitzoo.rosalind

object OverlapGraphs {

  /**
   * Given a collection of DNA strings in FASTA format,
   * return a list of pairs of strings that overlap by 3 characters.
   * The pairs must be ordered so that the overlapping characters
   * occur at the end of the first item and the beginning of the second item.
   */
  def getAnswer(fileName: String): List[Tuple2[String, String]] = {
    val dnaStrings = Util.getFastaDnaStringsFromFile(fileName)
    var overlapGraph = List[Tuple2[String, String]]()

    // compare each DNA string with all of the others
    for (a <- dnaStrings) {
      for (b <- dnaStrings.filter(x => x != a)) {
        
        // if the last three characters of the first are the same as the last three of the second
        if (a._2.takeRight(3) == b._2.take(3))
          
          // add this pair of strings to the overlap graph
          overlapGraph = (a._1, b._1) :: overlapGraph
      }
    }
    
    overlapGraph
  }

}