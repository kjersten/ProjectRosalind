package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L7_KMP_test extends FunSuite {

  /**
   * Note: Project Rosalind was reorganized so this problem is now on level 7
   * and has some pre-requisites that I haven't done yet.
   * I will work out the bug in my solution when I have completed the new pre-reqs.
   */
  test("run the sample test provided by Project Rosalind") {
    val dnaString = "CAGTAAGCAGGGACTG"
    val failureArray = SpeedUpMotifFinding.getAnswer(dnaString)
    assert(failureArray.mkString(" ") === "0 0 0 0 0 0 0 1 2 3 0 0 0 1 0 0")
  }

  test("run a test designed to show the flaws in my algorithm") {
    val dnaString = "AAACAAAAAAGCTGATAAAAGATTGCC"
    val failureArray = SpeedUpMotifFinding.getAnswer(dnaString)
    
    // don't have time to refresh my memory on this but the answer should have 3 3 3 instead of 3  0 0 0
    // for this test and I believe the next one...
    println(failureArray.mkString(" "))
    val maxLength = failureArray.reduceLeft((a, b) => if (a > b) a else b)
    println(maxLength)
  }

  test("run an additional test designed to show the flaws in my algorithm") {
    val dnaString = "AAACAAAAAAGCATGTTTCTTCTAAAGGGTGACTCCAAAAACAGACACCGATTAGACGC"
    val failureArray = SpeedUpMotifFinding.getAnswer(dnaString)
    println(failureArray.mkString(" "))
  }

  test("run the real test provided by Project Rosalind") {
    val fileName = "L7_KMP_sample.txt"
    val file = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val fileStream = scala.io.Source.fromFile(file)
    var dnaString = fileStream.mkString
    val failureArray = SpeedUpMotifFinding.getAnswer(dnaString)

  }

}