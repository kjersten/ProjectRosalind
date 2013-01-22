package net.bitzoo.rosalind

object ProteinTranslation {

  /**
   * Translate the given RNA string into a protein
   */
  def getAnswer(fileName: String): String = {
    val rnaCodons = getRnaCodonsFromFile(fileName)
    var protein = new StringBuilder

    for (rnaCodon <- rnaCodons) {
      val aminoAcid = Util.rnaCodonTable.get(rnaCodon)
      if (!aminoAcid.isEmpty) protein += aminoAcid.get
    }

    protein.toString()
  }

  /** 
   * Parse out a list of the RNA codons from the first line of the file 
   */
  def getRnaCodonsFromFile(fileName: String): List[String] = {
    val lines = Util.getListOfStringsFromFile(fileName)
    lines(0).grouped(3).toList
  }

}