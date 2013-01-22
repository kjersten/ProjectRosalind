package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L5_GRPH_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val fileName = "L5_GRPH_test.txt"
    val answer = OverlapGraphs.getAnswer(fileName)
    assert(answer.contains(("Rosalind_0498", "Rosalind_2391")))
    assert(answer.contains(("Rosalind_0498", "Rosalind_0442")))
    assert(answer.contains(("Rosalind_2391", "Rosalind_2323")))
    assert(answer.size === 3)
  }

  test("run the real test provided by Project Rosalind") {
    val fileName = "L5_GRPH_real.txt"
    val answer = OverlapGraphs.getAnswer(fileName)
    answer.foreach(a => println(a._1 + " " + a._2))
  }

}