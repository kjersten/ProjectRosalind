package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L4_SUBS_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val bigString = "GATATATGCATATACTT"
    val smallString = "ATAT"
    val answer = FindAMotif.getAnswer(bigString, smallString)
    assert(answer.mkString(" ") === "2 4 10")
  }
  
  test("run the real test provided by Project Rosalind") {
    val bigString = "CCCGAACACTCTCTCACTCTCAGCACTCTCCAACACTCTCGACCACTCTCGCACTCTCACACTCTCCACTCTCTCCACTCTCGGGTGTGTTCACTCTCCACTCTCCACTCTCCACAACCACTCTCTCCACTCTCCACTCTCGTCACTCTCTGTGCACTCTCCCTCGTCGTCACTCTCGCCACTCTCAGCATCCACTCTCGTCACTCTCTTCCGCAAAACACTCTCACACTCTCATCACTCTCAACGTTCACTCTCCACTCTCACATCGCACTCTCACACTCTCACCACTCTCACACTCTCCACTCTCGCTCACTCTCTCACTCTCACTCACTCTCTAAGATTGTGTCTCAATCACTCTCGCACTCTCTCACTCTCCCACTCTCACACTCTCGGCTCCGCACTCTCGTATGACACTCTCCACTCTCTCCCCACTCTCTACACTCTCCTGTACAACACACTCTCGTTCACTCTCTTTCACTCTCATTACACTCTCTGCACTCTCGGGATTCACTCTCTACCCACTCTCCACTCTCCATCACTCTCCGGCCGTCTTCACTCTCCGCACTCTCTTCCACTCTCCAACAAGCCCCACTCTCTGCCAGCTAGCTCACTCTCCACTCTCGAGCCATACACTCTCCACTCTCCCACTCTCCTATACACTCTCCCACTCTCCACTCTCCACTCTCCACTCTCACACTCTCCCACTCTCTCTGCACTCTCCCACTCTCCGACACTCTCGTCACTCTCCGGAAACACTCTCCACTCTCTAGGTTTTTCACTCTCGTCACTCTCACACTCTCGCACTCTCCACTCTCTAGACACTCTCCACTCTCTTCCTAGCTCACGTATCACTCTCTGACACTCTCTGCACTCTCTACACTCTCTGGTCACTCTCCACTCTCCCTACACTCTC"
    val smallString = "CACTCTCCA"
    val answer = FindAMotif.getAnswer(bigString, smallString)
    println(answer.mkString(" "))
  }

}