package net.bitzoo.rosalind

object GCContent {

  /**
   * For a given list of DNA strings, return:
   * 1. the ID of the string with the greatest GC content
   * 2. the GC content of that string, within an absolute error of 0.001
   */
  def getAnswer(fileName: String): Tuple2[String, String] = {

    // parse the list of DNA strings from the file
    val dnaStrings = Util.getDnaStringsFromFile(fileName)
    
    // calculate the GC content of each DNA string
    var dnaGCContent = Map[String, BigDecimal]()
    dnaStrings.foreach(kvPair => {
      val numTotal: BigDecimal = kvPair._2.size
      val numGC: BigDecimal = kvPair._2.count(char => char == 'C' || char == 'G')
      dnaGCContent = dnaGCContent + (kvPair._1 -> numGC / numTotal);
    })

    // find and return the DNA string with the greatest GC content
    val greatestGCContent = dnaGCContent.reduceLeft((x, y) => if (x._2 > y._2) x else y)
    (greatestGCContent._1, greatestGCContent._2.*(100).round(java.math.MathContext.DECIMAL32) + "%")
  }

}