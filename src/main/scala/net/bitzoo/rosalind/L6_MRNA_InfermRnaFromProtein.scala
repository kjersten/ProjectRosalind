package net.bitzoo.rosalind

object InfermRnaFromProtein {

  def main(args: Array[String]): Unit = {

    val protein = "MA"
    val protein2 = "MLPKKYQISQHGQWMKNGKVFETSPMDGCVWVLAGFMWCIRLGYVLTQCYALCQQQWHFRGVWTYGNVHITYNCSQMKNYKIFDVHDLTNTEDNNNRPLNAVYYYPQMGLMCTAWFGNKYMSNACRHNSKTVCMIHKLVVLDNARQQRAMGRELRAYRNEIVRWDWYNLLHPIINMKRAKVMCTGCNWMPMEPWSKCGNHYYIYACYMDEHMYMCTCHKYEDYCCKTEMHLPVIMCWPYLYECFVWSSAGPRSFKDAPNHENGQYKGWKNWYSKEVRIVMNLIDNDKTFTTPINVMMPVVKRRQFCMCYPATSTPYYACSDPEFARCEPSPDEDPEGTAMYEQDCVDQGGTCSSGRSCCFMPDWLLPHQWTCEEYKIIINWHPKDSNVVIRHIYFWAPQLEWWLQMITQAGAAPHDTQEWNLRSEHYQFKPMGVEYFNLPTTCNCSWEDDCEAMYVSIKLYHAWLQRLMPSMCPVYDIKEKAPEACAIQNAGDDDDTLLQRKTTTWPCSINSLHIWYVVVSSNIHGMERVNFRVHHFAYYKYLMNGTTPHAGHQLRYGWNEANGAINQNKPGTPDSGPEINDWNEDQVNEFPDEYPSPMSNMHETLHFKYFPKTSVIARAVHISMLDCLAMKPRWMDYTVRFVNDTQKELMCGALPKNHSSNHFMAKTNKMNVCTTMYEWSFKDENSPTTDKPFAFRLMPKVMWYYICFRRLPKSTRYLHMVFQCADMDLMQRWFSPLEESRKHGNHPIYHECSSIHQLGMPCNFKWHCWYSFETTKLPKYAWYSGLCCRMSEVTVSTQISRTIFDTEVKHWPHEAQGTFWIWVWVIGKCMCCFFPQMISSEYSTIIPYRSWNQIDFIRVFMFSDKFWMASMNVYNEHTSGKVREQAYRDRGFFCMHKPDFSKAFQGADIFDCFFYMGEEPIVMNWEAKKKMARGYEKRAHDGPGFLWRLDPLMKHWAIVCYWQAASDAIWAVECPTDHKVITDEMFIVQPCFKLCHHH"
    var listNumOptions = List[BigInt]()

    for (aa <- protein2) {
      listNumOptions = findNumOptionsForAA(aa) :: listNumOptions
    }

    // add the number of options for encoding "STOP"
    listNumOptions = 3 :: listNumOptions
    
    Console.println(listNumOptions)

    val numPossibleRnaStrings: BigInt = listNumOptions.reduce((a, b) => a * b)

    Console.println(numPossibleRnaStrings)
    Console.println(numPossibleRnaStrings.mod(BigInt(1000000)))

  }

  var numOptions = Map[Char, BigInt]()

  def findNumOptionsForAA(aa: Char): BigInt = {
    var answer = BigInt(0)

    if (!numOptions.get(aa).isEmpty) {
      answer = numOptions.get(aa).get
    } else {
      val numOptsForThisChar = rnaCodonTable.filter(a => a._2 == aa).size
      numOptions = numOptions + (aa -> numOptsForThisChar)
      answer = numOptsForThisChar
    }

    answer
  }

  val rnaCodonTable = Map(
    "UUU" -> 'F',
    "CUU" -> 'L',
    "AUU" -> 'I',
    "GUU" -> 'V',
    "UUC" -> 'F',
    "CUC" -> 'L',
    "AUC" -> 'I',
    "GUC" -> 'V',
    "UUA" -> 'L',
    "CUA" -> 'L',
    "AUA" -> 'I',
    "GUA" -> 'V',
    "UUG" -> 'L',
    "CUG" -> 'L',
    "AUG" -> 'M',
    "GUG" -> 'V',
    "UCU" -> 'S',
    "CCU" -> 'P',
    "ACU" -> 'T',
    "GCU" -> 'A',
    "UCC" -> 'S',
    "CCC" -> 'P',
    "ACC" -> 'T',
    "GCC" -> 'A',
    "UCA" -> 'S',
    "CCA" -> 'P',
    "ACA" -> 'T',
    "GCA" -> 'A',
    "UCG" -> 'S',
    "CCG" -> 'P',
    "ACG" -> 'T',
    "GCG" -> 'A',
    "UAU" -> 'Y',
    "CAU" -> 'H',
    "AAU" -> 'N',
    "GAU" -> 'D',
    "UAC" -> 'Y',
    "CAC" -> 'H',
    "AAC" -> 'N',
    "GAC" -> 'D',
    "CAA" -> 'Q',
    "AAA" -> 'K',
    "GAA" -> 'E',
    "CAG" -> 'Q',
    "AAG" -> 'K',
    "GAG" -> 'E',
    "UGU" -> 'C',
    "CGU" -> 'R',
    "AGU" -> 'S',
    "GGU" -> 'G',
    "UGC" -> 'C',
    "CGC" -> 'R',
    "AGC" -> 'S',
    "GGC" -> 'G',
    "CGA" -> 'R',
    "AGA" -> 'R',
    "GGA" -> 'G',
    "UGG" -> 'W',
    "CGG" -> 'R',
    "AGG" -> 'R',
    "GGG" -> 'G')
  // stop codes... for the purposes of this exercise, we don't need to do anything special with them
  // so just leave them out
  //    "UGA" -> 'X',
  //    "UAG" -> 'X',
  //    "UAA" -> 'X',

}