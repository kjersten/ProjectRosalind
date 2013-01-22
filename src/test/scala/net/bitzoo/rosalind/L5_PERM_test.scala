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
    val number = 6
    val answer = EnumeratingGeneOrders.getAnswer(number)
    
    // write answer to file
    val fileName = "L5_PERM_answer.txt"
    val dateFile = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    
    val answerString = new StringBuffer(answer.size + "\n")

    for (sequence <- answer) {
      answerString.append(sequence.mkString(" ") + "\n")
    }

    Util.writeToFile(dateFile, answerString.toString())
  }

}