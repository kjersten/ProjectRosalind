package net.bitzoo.rosalind

object EnumeratingGeneOrders {

  /**
   * Given a positive integer less than or equal to 7,
   * return a list of the permutations in any order.
   */
  def getAnswer(permutationLength: Int): List[List[Int]] = {

    val options = (1 until permutationLength + 1).toList
    var sequences = List[List[Int]]()
    sequences = tryAllPermutations(options, List[Int](), sequences)

    sequences
  }

  def tryAllPermutations(opts: List[Int], seqSoFar: List[Int], listOfSeqs: List[List[Int]]): 
      List[List[Int]] = {
    var latestListOfSeqs = listOfSeqs
    
    if (opts.isEmpty) {
      latestListOfSeqs = seqSoFar :: latestListOfSeqs
    } else {
      for (opt <- opts) {
        latestListOfSeqs = 
          tryAllPermutations(opts.filter(a => a != opt), opt :: seqSoFar, latestListOfSeqs)
      }
    }
    
    latestListOfSeqs
  }

}