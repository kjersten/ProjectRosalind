package net.bitzoo.rosalind

object CountingPointMutations {

  def main(args: Array[String]): Unit = {

//    val fileName = "cons_real.txt"
    val fileName = "cons_sample.txt"
    val dnaStrings = getDnaStringsFromFile(fileName)
    var hammingDistance = 0

    for (i <- 0 to dnaStrings._1.length - 1) {
      if (dnaStrings._1.charAt(i) != dnaStrings._2.charAt(i)) hammingDistance += 1
    }

    Console.println(hammingDistance)
  }

  def getDnaStringsFromFile(fileName: String): Tuple2[String, String] = {

    // read from a file
    val file = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val fileStream = scala.io.Source.fromFile(file)

    var string1 = fileStream.getLine(0)
    var string2 = fileStream.getLine(1)

    // close the file
    fileStream.close()

    // return the map
    (string1, string2)
  }

}