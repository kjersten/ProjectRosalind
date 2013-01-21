package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L4_HAMM_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val fileName = "L4_HAMM_test.txt"
    val answer = CountingPointMutations.getAnswer(fileName)
    assert(answer === 7)
  }
  
  test("run the real test provided by Project Rosalind") {
    val fileName = "L4_HAMM_real.txt"
    val answer = CountingPointMutations.getAnswer(fileName)
    println(answer)
  }

}
