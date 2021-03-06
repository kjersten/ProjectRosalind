package net.bitzoo.rosalind

import org.scalatest.FunSuite

class L2_RNA_test extends FunSuite {

  test("run the sample test provided by Project Rosalind") {
    val question = "GATGGAACTTGACTACGTAAATT"
    val answer = RnaTranscription.getAnswer(question)
    assert(answer === "GAUGGAACUUGACUACGUAAAUU")
  }
  
  test("run the real test provided by Project Rosalind") {
    val question = "TACGTGAGCCTGGCTGAAATCAGGCAGCCCGCATTACAAGAACAATTTTCGCCTCGCTTGCCGGTTTAACATTCCGAGCGAAGTTTAGACCATAATCCCATGTCTTACGCTGACCGGTGGCAAAATGAGTCTTTTGGCTCGTGTGTCTTGTGGCACAAGCAATTGTACTTGCACGGCTCTAAGCCGTACCGCCTCCAAAGGCGGTTCCGCGAAGGGCAATCAGGTGGTGGACCGCACAGACAAGAGGTTTTGCCGTTCTTCGGCGATGATCCGTTCACGTGTCTCTGTGTTGGCCCATTGCACGTAGATATAGCTGGAAGTTGCATATTTGGTAGAACACAACTACGCAGAAGAACGCTTGTGTCGCATCAGCGATCGATCCGGGCCCGCCGATGTAACAAGTGGGACACTACTGCGGACCGGTGAATAATGTAGGGGAAGCTTGTGCGCGTGCACATCAGTCCGAGGTCGACGACGTAAATAGAATTAGCATCAGAAGATTTAATCCGATAACGACATACAATTCCGATCCGGCGTTCCATCTCAACACTAAACACCAAGACCGGGTTATGTGTACCCTCGCTCAGTTGTTTTCCCCTTTCCTCCGTGTATGATTCTAATGTACTTGAAAAACGACTAGTCTTTCCTCAGCGTGGCATGAGTTGATTGTCGAGAGTTGAATCGACTTACGACGAGAAATTCTTAGGCGAGCCAGCCTGGGCAGCTTGTAGGACGTTTGCTGTCTCCGGCTCGTTGCCGATAATACATAGTCTTCGAATGTCTGGTTAAAGGCTTTGCCGAATATGTGCACCGCAACCACATTCCGAAACACGTACACGGAATTAGTCCCCTATTAATGAGTTGAAACGCTGTAGCATCGAGTGATATCGGCGCTTGAAGCCAGACGAAGCAGTGCTAGCAAAGATTTTTTGTCCTGGCACGGACAAGGCAGCCAGAAGC"
    val answer = RnaTranscription.getAnswer(question)
    println(answer)
  }

}