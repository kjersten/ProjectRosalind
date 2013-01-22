package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L5_PERM_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val number = 3
    val answer = EnumeratingGeneOrders.getAnswer(number)

    assert(answer.size === 6)
    assert(answer.contains(List(1, 2, 3)))
    assert(answer.contains(List(1, 3, 2)))
    assert(answer.contains(List(2, 1, 3)))
    assert(answer.contains(List(2, 3, 1)))
    assert(answer.contains(List(3, 1, 2)))
    assert(answer.contains(List(3, 2, 1)))
  }

  test("run the real test provided by Project Rosalind") {
    val number = 7
    val answer = EnumeratingGeneOrders.getAnswer(number)
    Util.writeListOfPermutationsToFile("L5_PERM_answer.txt", answer)
  }

}