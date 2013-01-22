package net.bitzoo.rosalind

object CalculatingProteinMass {

  /**
   * Given a protein string no more than 1,000 amino acids long,
   * return the weight of the protein
   */
  def getAnswer(proteinString: String): BigDecimal = {
   var weights = List[BigDecimal]()

    for(aa <- proteinString) {
      val mass = monoisotopicMassTable.get(aa)
      if(!mass.isEmpty) weights = mass.get :: weights
    }
    
    weights.reduce((a, b) => a + b)
  }

  // table used for calculating the masses of amino acid residues
  // using the most common isotope of each atom occurring in the amino acid
  val monoisotopicMassTable = Map(
    'A' -> BigDecimal(71.03711),
    'C' -> BigDecimal(103.00919),
    'D' -> BigDecimal(115.02694),
    'E' -> BigDecimal(129.04259),
    'F' -> BigDecimal(147.06841),
    'G' -> BigDecimal(57.02146),
    'H' -> BigDecimal(137.05891),
    'I' -> BigDecimal(113.08406),
    'K' -> BigDecimal(128.09496),
    'L' -> BigDecimal(113.08406),
    'M' -> BigDecimal(131.04049),
    'N' -> BigDecimal(114.04293),
    'P' -> BigDecimal(97.05276),
    'Q' -> BigDecimal(128.05858),
    'R' -> BigDecimal(156.10111),
    'S' -> BigDecimal(87.03203),
    'T' -> BigDecimal(101.04768),
    'V' -> BigDecimal(99.06841),
    'W' -> BigDecimal(186.07931),
    'Y' -> BigDecimal(163.06333))

}