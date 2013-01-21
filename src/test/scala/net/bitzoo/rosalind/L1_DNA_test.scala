package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L1_DNA_test extends FunSuite {

  test("run the test") {
    // this sample and its answer are given by Project Rosalind
    val sample = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
    val answer = CountingNucleotides.getAnswer(sample)
    assert(answer === "(20,12,17,21)")

    // when my code correctly answers the above assertion, I can test it against the real question
    val real = "AACCGCGGGGGCCAGAGGTACCTTACCATATCGCCGTCCATCTCAATCAATGGAATGTTAGGATAGATGCTGTTCTCGTAATTGGCTTTACCCGAGCCGAAATACGCTGCCTGAAACTGGTGCTGAGCATGGCTCGGAAGTCCGGTGAGATTATCGGACATGATTCCCTTTACCTTACCTGAACTTGAAACTAAATCGGATGGCGATCATCGGAATACTAGAGATCCGCTCAGCGCGGTACCAGGTGCCTCTTGGTACCCTGACTGGATGGTCCAGAATCAATGCCTGCTCATCGGGATAAAAGCAGGGATATATGCCACTAACTCTGGTCTCGCGTTTCACCGTCGACGATGTTCGACCAGGGCGACATGCTTGGCCTTCTTAGTCGCAGGCAGACAGTATGTGGCGTCATCGAGAGGCGGCTCCCGACGAATTTATGTTATAATTTAAAATGCCGGAACGTAATTAATAAATCGGGCCACTCTACGTGGAACTTAATCATCACTCATGAATTAGCTGCATCTTGGCCTATAGCTACACATAGGCGTCTTATGGGGGGTGGCACCACTATGGTTAAGAATTATTGAAGCGCCTGGTAATGGCCACAGATACCAGACCGTTGGGGGCTCTACGATGCTTCTCAATTGTGCCCCAGAGATTGTCCAACGCGAAATAAGTATCAGCTATGGGGGCTGAGGGACTGCAGAAGCACTACTCACCAAGCCGGGACTCCCCAATCTTCAGGCGGCTCTTCCGAAACTTTGCGAGTTTCATCTTGCTTCGTATCCTTCGAGTTACTTTATTTTATGCCGACGTGTTACTTGACCCAG"
    val realAnswer = CountingNucleotides.getAnswer(real)
    println(realAnswer)
  }

}