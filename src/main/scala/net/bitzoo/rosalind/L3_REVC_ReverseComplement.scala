package net.bitzoo.rosalind

object ReverseComplement {

  /** For a given DNA string, return the reverse complement 
   * (i.e. switch G and C; switch A and T)
   */
  def getAnswer(dnaString: String): String = {
    dnaString.reverse.map(x =>
      if (x == 'C') 'G'
      else if (x == 'G') 'C'
      else if (x == 'A') 'T'
      else 'A')
  }

}