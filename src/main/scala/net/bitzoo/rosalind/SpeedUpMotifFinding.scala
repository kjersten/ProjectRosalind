package net.bitzoo.rosalind

object SpeedUpMotifFinding {

  def main(args: Array[String]): Unit = {

    //    val big = "CAGTAAGCAGGGACTG"
    val fileName = "kmp_sample.txt"
    val file = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val fileStream = scala.io.Source.fromFile(file)
    var big = fileStream.mkString
        big = "AAACAAAAAAGCTGATAAAAGATTGCC"
//    big = "AAACAAAAAAGCATGTTTCTTCTAAAGGGTGACTCCAAAAACAGACACCGATTAGACGC"
    val small = big.dropRight(1)

    var j = 0
    val failureArray = Array.ofDim[Int](big.length)

    for (i <- 1 until big.length) {
      if (small(j) == big(i)) {
        j = j + 1
      } else {
        j = 0
        if(small(j) == big(i)) {
          j = j + 1
        }
      }
      failureArray(i) = j
    }
    
    
    val maxLength = failureArray.reduceLeft((a, b) => if(a > b) a else b)
    println(maxLength)
    
//    for(x <- 0 until maxLength) {
//      failureArray(x) = 0
//    }

    println(big.toCharArray().mkString(" "))
    println(failureArray.mkString(" "))
    val answerFile = new java.io.File(ClassLoader.getSystemResource("kmp_answer.txt").toURI())
    Util.writeToFile(answerFile, failureArray.mkString(" "))

  }

}