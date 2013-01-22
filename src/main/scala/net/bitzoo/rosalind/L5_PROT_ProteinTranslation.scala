package net.bitzoo.rosalind

object ProteinTranslation {

  /**
   * Translate the given RNA string into a protein
   */
  def getAnswer(fileName: String): String = {
    val rnaCodons = getRnaCodonsFromFile(fileName)
    var protein = new StringBuilder

    for (rnaCodon <- rnaCodons) {
      val aminoAcid = rnaCodonTable.get(rnaCodon)
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

  val rnaCodonTable = Map(
    "UUU" -> 'F',
    "CUU" -> 'L',
    "AUU" -> 'I',
    "GUU" -> 'V',
    "UUC" -> 'F',
    "CUC" -> 'L',
    "AUC" -> 'I',
    "GUC" -> 'V',
    "UUA" -> 'L',
    "CUA" -> 'L',
    "AUA" -> 'I',
    "GUA" -> 'V',
    "UUG" -> 'L',
    "CUG" -> 'L',
    "AUG" -> 'M',
    "GUG" -> 'V',
    "UCU" -> 'S',
    "CCU" -> 'P',
    "ACU" -> 'T',
    "GCU" -> 'A',
    "UCC" -> 'S',
    "CCC" -> 'P',
    "ACC" -> 'T',
    "GCC" -> 'A',
    "UCA" -> 'S',
    "CCA" -> 'P',
    "ACA" -> 'T',
    "GCA" -> 'A',
    "UCG" -> 'S',
    "CCG" -> 'P',
    "ACG" -> 'T',
    "GCG" -> 'A',
    "UAU" -> 'Y',
    "CAU" -> 'H',
    "AAU" -> 'N',
    "GAU" -> 'D',
    "UAC" -> 'Y',
    "CAC" -> 'H',
    "AAC" -> 'N',
    "GAC" -> 'D',
    "CAA" -> 'Q',
    "AAA" -> 'K',
    "GAA" -> 'E',
    "CAG" -> 'Q',
    "AAG" -> 'K',
    "GAG" -> 'E',
    "UGU" -> 'C',
    "CGU" -> 'R',
    "AGU" -> 'S',
    "GGU" -> 'G',
    "UGC" -> 'C',
    "CGC" -> 'R',
    "AGC" -> 'S',
    "GGC" -> 'G',
    "CGA" -> 'R',
    "AGA" -> 'R',
    "GGA" -> 'G',
    "UGG" -> 'W',
    "CGG" -> 'R',
    "AGG" -> 'R',
    "GGG" -> 'G')
  // stop codes... for the purposes of this exercise, we don't need to do anything special with them
  // so just leave them out
  //    "UGA" -> 'X',
  //    "UAG" -> 'X',
  //    "UAA" -> 'X',

}