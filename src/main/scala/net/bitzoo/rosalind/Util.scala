package net.bitzoo.rosalind

object Util {

  // from http://stackoverflow.com/questions/4604237/how-to-write-to-a-file-in-scala
  def using[A <: { def close(): Unit }, B](param: A)(f: A => B): B =
    try { f(param) } finally { param.close() }

  /** given a File object, writes a string to that file */
  def writeToFile(fileName: java.io.File, data: String) =
    using(new java.io.FileWriter(fileName)) {
      fileWriter => fileWriter.write(data)
    }

  /**
   * Reads DNA strings from a file in FASTA format.  In FASTA format, the string
   * is introduced by a line that begins with '>', followed by some labeling information.
   * Subsequent lines contain the string itself; the first line to begin with '>' indicates
   * the label of the next string.
   *
   * >Rosalind_6404
   * CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC
   * TCCCACTAATAATTCTGAGG
   * >Rosalind_5959
   * CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAG
   */
  def getFastaDnaStringsFromFile(fileName: String): Map[String, String] = {

    // read from a file
    val file = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val fileStream = scala.io.Source.fromFile(file)

    var currentLabel = ""
    var currentString = ""
    var dnaStrings = Map[String, String]()

    for (line <- fileStream.getLines()) {
      if (line.startsWith(">")) {
        if (!currentLabel.isEmpty()) dnaStrings = dnaStrings + (currentLabel -> currentString)
        currentLabel = line.substring(1)
        currentString = ""
      } else {
        currentString += line
      }
      dnaStrings = dnaStrings + (currentLabel -> currentString)
    }

    // close the file
    fileStream.close()

    // return the map
    dnaStrings
  }

  /**
   * Parse strings from a file, assuming that
   * each line is a self-contained string
   */
  def getListOfStringsFromFile(fileName: String): List[String] = {

    // read from a file
    val file = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val fileStream = scala.io.Source.fromFile(file)
    var strings = List[String]()

    // populate list of DNA strings
    fileStream.getLines().foreach(line => strings = line :: strings)

    // close the file
    fileStream.close()

    // return the list
    strings
  }

  // a table translating RNA codons into amino acids
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
  // stop codes... for the purposes of the exercises so far, 
  // we don't need to do anything special with them
  // so just leave them out
  //    "UGA" -> 'X',
  //    "UAG" -> 'X',
  //    "UAA" -> 'X',

}