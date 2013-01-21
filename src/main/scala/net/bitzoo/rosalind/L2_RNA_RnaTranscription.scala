package net.bitzoo.rosalind

object RnaTranscription {

  /** 
   * For a given DNA string, return the corresponding RNA string
   */
  def getAnswer(dnaSeq: String): String = {
    dnaSeq.replaceAll("T", "U")
  }

}