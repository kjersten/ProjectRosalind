package net.bitzoo.rosalind


import org.scalatest.FunSuite

class L4_GC_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val fileName = "L4_GC_test.txt"
    val answer = GCContent.getAnswer(fileName)
    assert(answer._1 === "Rosalind_0808")
    assert(answer._2 === "60.91954%")
  }
  
  test("run the real test provided by Project Rosalind") {
    val fileName = "L4_GC_real.txt"
    val answer = GCContent.getAnswer(fileName)
    println(answer._1)
    println(answer._2)
  }

}