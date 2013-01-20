package net.bitzoo.rosalind

object OverlapGraphs {

  def main(args: Array[String]): Unit = {
    // parse the list of DNA strings from the sample dataset or the real dataset
    //    val fileName = "L5_GRPH_test.txt"
    val fileName = "L5_GRPH_real.txt"
    val dnaStrings = getDnaStringsFromFile(fileName)

    for (a <- dnaStrings) {
      for (b <- dnaStrings.filter(x => x != a)) {
        if (a._2.takeRight(3) == b._2.take(3))
          Console.println(a._1 + " " + b._1)
      }
    }

  }

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

}