package net.bitzoo.rosalind

object SpeedUpMotifFinding {

  /**
   * Given a DNA string, return its failure array
   * 
   * Note: Project Rosalind was reorganized so this problem is now on level 7
   * and has some pre-requisites that I haven't done yet.  
   * I will work out the bug in my solution when I have completed the new pre-reqs.
   */
  def getAnswer(dna: String): Array[Int] = {
    val small = dna.dropRight(1)

    var j = 0
    val failureArray = Array.ofDim[Int](dna.length)

    for (i <- 1 until dna.length) {
      if (small(j) == dna(i)) {
        j = j + 1
      } else {
        j = 0
        if(small(j) == dna(i)) {
          j = j + 1
        }
      }
      failureArray(i) = j
    }
    
    failureArray
  }

}