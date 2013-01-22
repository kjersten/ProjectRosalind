package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L5_CONS_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val fileName = "L5_CONS_test.txt"
    val answer = ConsensusAndProfile.getAnswer(fileName)
    
    // confirm that the consensus is correct
    assert(answer._2.mkString("") === "ATGCAACT")
    
    // confirm that the profile is correct
    val profile = answer._1
    assert(profile.get('A').get.mkString(" ") === "5 1 0 0 5 5 0 0")
    assert(profile.get('C').get.mkString(" ") === "0 0 1 4 2 0 6 1")
    assert(profile.get('G').get.mkString(" ") === "1 1 6 3 0 1 0 0")
    assert(profile.get('T').get.mkString(" ") === "1 5 0 0 0 1 1 6")
  }
  
  test("run the real test provided by Project Rosalind") {
    val fileName = "L5_CONS_real.txt"
    val answer = ConsensusAndProfile.getAnswer(fileName)
    println(answer._2.mkString(""))
    answer._1.foreach(a => println(a._1 + ": " + a._2.mkString(" ")))
  }

}