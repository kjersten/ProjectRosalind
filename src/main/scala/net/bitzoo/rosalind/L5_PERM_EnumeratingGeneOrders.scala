package net.bitzoo.rosalind

object EnumeratingGeneOrders {

  val options = List(1, 2, 3, 4, 5, 6, 7)
  var sequences = List[List[Int]]()

  def main(args: Array[String]): Unit = {

    val fileName = "L5_PERM_answer.txt"
    val dateFile = new java.io.File(ClassLoader.getSystemResource(fileName).toURI())
    val answer = new StringBuffer("")

    tryAllPermutations(options, List[Int]())
    answer.append(sequences.size + "\n")
    for (sequence <- sequences) {
      answer.append(sequence.mkString(" ") + "\n")
    }

    Util.writeToFile(dateFile, answer.toString())
    Console.println(answer.toString())

  }

  def tryAllPermutations(opts: List[Int], seq: List[Int]) {
    if (opts.isEmpty) {
      sequences = seq :: sequences
    } else {
      for (opt <- opts) {
        tryAllPermutations(opts.filter(a => a != opt), opt :: seq)
      }
    }
  }

}