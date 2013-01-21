package net.bitzoo.rosalind

object ReverseComplement {

  def getAnswer(dnaString: String): String = {
    dnaString.reverse.map(x =>
      if (x == 'C') 'G'
      else if (x == 'G') 'C'
      else if (x == 'A') 'T'
      else 'A')
  }

}