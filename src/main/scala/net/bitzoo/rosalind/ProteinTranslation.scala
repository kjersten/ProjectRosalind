package net.bitzoo.rosalind

object ProteinTranslation {

  def main(args: Array[String]): Unit = {

//    val fileName = "prot_sample.txt"
    val fileName = "prot_real.txt"
    val rnaCodons = getRnaCodonsFromFile(fileName)
    var proteinString = new StringBuilder
    
    for(rnaCodon <- rnaCodons) {
      val aminoAcid = rnaCodonTable.get(rnaCodon)
      if(!aminoAcid.isEmpty) proteinString += aminoAcid.get
    }
    
    Console.println(proteinString)

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

  def getRnaCodonsFromFile(fileName: String): List[String] = {

    // read from a file
    val file = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val fileStream = scala.io.Source.fromFile(file)
    val rnaString = fileStream.mkString
    val rnaCodons = rnaString.grouped(3).toList

    // close the file
    fileStream.close()

    // return the map
    rnaCodons
  }

}