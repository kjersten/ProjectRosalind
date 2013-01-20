package net.bitzoo.rosalind

object ConsensusAndProfile {

  val bases = List('A', 'C', 'G', 'T')

  def main(args: Array[String]): Unit = {

    val fileName = "L5_CONS_test.txt"
    val fileName2 = "L5_CONS_real.txt"
    val dnaStrings = getDnaStringsFromFile(fileName2)
    val profile = getInitialProfileMap(dnaStrings.first.length)

    for (dnaString <- dnaStrings) {
      for (i <- 0 to dnaString.size - 1) {
        val aa = dnaString(i)
        val profilesForAA = profile.get(aa).get
        profilesForAA(i) = profilesForAA(i) + 1
      }
    }
    
    val consensus = Array.ofDim[Char](dnaStrings.first.length)
    for(i <- 0 to consensus.size - 1) {
      // if a and b are equal, b will win... Rosalind does not require all possibilities
      val mostCommon = profile.reduceLeft((a, b) => if(a._2(i) > b._2(i)) a else b)
      consensus(i) = mostCommon._1
    }

    println(consensus.mkString(""))
    profile.foreach(a => println(a._1 + ": " + a._2.mkString(" ")))
  }

  def getInitialProfileMap(arrayLength: Int): Map[Char, Array[Int]] = {
    var profile = Map[Char, Array[Int]]()

    // the map should have an int list for each base pair
    bases.foreach(x => profile = profile + (x -> Array.ofDim[Int](arrayLength)))

    // return the map
    profile
  }

  def getDnaStringsFromFile(fileName: String): List[String] = {

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