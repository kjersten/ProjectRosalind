package net.bitzoo.rosalind

object CountingNucleotides {

  def getAnswer(polymer: String): String = {
    val bases = Set('A', 'C', 'G', 'T')
    var result = Map[Char, Int]()

    val start1 = System.currentTimeMillis()
    for (base <- bases) {
      result = result + (base -> polymer.count(_ == base))
    }
    val end1 = System.currentTimeMillis();
    Console.println(result.mkString(", "))
    Console.println("Iterating through the dataset once for each base took " + (end1 - start1) + " milliseconds\n\n")

    val start2 = System.currentTimeMillis()
    val result2: Tuple4[Int, Int, Int, Int] = polymer.
      map(nt =>
        if (nt == 'A') (1, 0, 0, 0)
        else if (nt == 'C') (0, 1, 0, 0)
        else if (nt == 'G') (0, 0, 1, 0)
        else if (nt == 'T') (0, 0, 0, 1)
        else /* bad data */ (0, 0, 0, 0)).
      reduce((x, y) =>
        (x._1 + y._1, x._2 + y._2, x._3 + y._3, x._4 + y._4))
    val end2 = System.currentTimeMillis();

    println(result2)
    Console.println("Using mapreduce took " + (end2 - start2) + " milliseconds\n\n")
    
    result2.toString()

  }
}