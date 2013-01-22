package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L5_PROT_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val fileName = "L5_PROT_test.txt"
    val answer = ProteinTranslation.getAnswer(fileName)
    assert(answer === "MAMAPRTEINSTRING")

  }
  
  test("run the real test provided by Project Rosalind") {
    val fileName = "L5_PROT_real.txt"
    val answer = ProteinTranslation.getAnswer(fileName)
    println(answer)
  }

}