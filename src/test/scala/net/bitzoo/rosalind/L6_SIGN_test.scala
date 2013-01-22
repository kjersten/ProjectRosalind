package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L6_SIGN_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
	val permutationLength = 2
    val answer = EnumeratingOrientedGeneOrders.getAnswer(permutationLength)
    assert(answer.size === 8)
    assert(answer.contains(List(1, 2)))
    assert(answer.contains(List(2, 1)))
    assert(answer.contains(List(-1, -2)))
    assert(answer.contains(List(-2, -1)))
    assert(answer.contains(List(-1, 2)))
    assert(answer.contains(List(1, -2)))
    assert(answer.contains(List(-2, 1)))
    assert(answer.contains(List(2, -1)))

  }
  
  test("run the real test provided by Project Rosalind") {
    val permutationLength = 6
    val answer = EnumeratingOrientedGeneOrders.getAnswer(permutationLength)
    Util.writeListOfPermutationsToFile("L6_SIGN_answer.txt", answer)
  }

}