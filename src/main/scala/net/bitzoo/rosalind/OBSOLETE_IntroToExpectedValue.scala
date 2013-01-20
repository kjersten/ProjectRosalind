package net.bitzoo.rosalind

/*
 * This problem is no longer in the Project Rosalind problem set
 */
object IntroToExpectedValue {

  def main(args: Array[String]): Unit = {

    val line1 = "2 10"
    val line2 = "0.32 0.42 0.81"
    val lenSmall = line1.split(" ")(0).toInt
    val lenBig = line1.split(" ")(1).toInt
    val gcContentArray = line2.split(" ").toList.map(x => BigDecimal(x))
    
    for(gcContent <- gcContentArray) {
      val probg = gcContent/2
      val probt = (1 -gcContent)/2
      val probMultipleSymbolsSameArray = (probg.pow(lenSmall) + probt.pow(lenSmall)) * 2
      
      println(probMultipleSymbolsSameArray)
    }
    
    println(gcContentArray)

  }

}