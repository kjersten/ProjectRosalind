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
  def getDnaStringsFromFile(fileName: String): Map[String, String] = {

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

  /** parse strings from a file, assuming that each line contains a DNA string */
  def getListOfDnaStringsFromFile(fileName: String): List[String] = {

    // read from a file
    val file = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val fileStream = scala.io.Source.fromFile(file)
    var dnaStrings = List[String]()

    // populate list of DNA strings
    fileStream.getLines().foreach(line => dnaStrings = line :: dnaStrings)

    // close the file
    fileStream.close()

    // return the list
    dnaStrings
  }

}