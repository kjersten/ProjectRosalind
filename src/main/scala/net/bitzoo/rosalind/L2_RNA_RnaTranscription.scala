package net.bitzoo.rosalind

object RnaTranscription {

  def getAnswer(dnaSeq: String): String = {
    dnaSeq.replaceAll("T", "U")
  }

}