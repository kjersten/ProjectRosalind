package net.bitzoo.rosalind

object GCContent {

  def main(args: Array[String]): Unit = {

    // parse the list of DNA strings from the sample dataset or the real dataset
//    val fileName = "L4_GC_test.txt"
    val fileName = "L4_GC_real.txt"
    val dnaStrings = getDnaStringsFromFile(fileName)
    
    // initialize a map of all DNA strings and their GC content
    var dnaGCContent = Map[String, BigDecimal]()

    // calculate the GC content of each DNA string
    dnaStrings.foreach(kvPair => {
      val numTotal: BigDecimal = kvPair._2.size
      val numGC: BigDecimal = kvPair._2.count(char => char == 'C' || char == 'G')
      dnaGCContent = dnaGCContent + (kvPair._1 -> numGC / numTotal);
    })

    // find the DNA string with the greatest GC content
    val greatestGCContent = dnaGCContent.reduceLeft((x, y) => if (x._2 > y._2) x else y)
    
    // print the results
    Console.println(greatestGCContent._1)
    Console.println(greatestGCContent._2.*(100).round(java.math.MathContext.DECIMAL32) + "%")

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