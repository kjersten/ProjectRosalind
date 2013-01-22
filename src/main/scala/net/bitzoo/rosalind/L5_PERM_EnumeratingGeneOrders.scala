package net.bitzoo.rosalind

object EnumeratingGeneOrders {

  /**
   * Given a positive integer less than or equal to 7,
   * return a list of the permutations in any order.
   */
  def getAnswer(permutationLength: Int): List[List[Int]] = {

    val options = (1 to permutationLength).toList
    var sequences = List[List[Int]]()
    sequences = tryAllPermutations(options, List[Int](), sequences)

    sequences
  }

  /** 
   * Try all permutations, given a list of the current options and the sequence so far.
   * When there are no more options, add the sequence so far to the master sequence list.
   */
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