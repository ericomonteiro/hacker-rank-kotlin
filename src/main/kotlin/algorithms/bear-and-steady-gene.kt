package algorithms

//https://www.hackerrank.com/challenges/bear-and-steady-gene/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign



// Complete the steadyGene function below.
fun steadyGene(s: String): Int {

    val GENE_OPTIONS = charArrayOf('A', 'C', 'T', 'G')
    val checkedWords = mutableListOf<String>()

    val fullStringGrouped = GENE_OPTIONS.map { STABLE -> STABLE.toString() to s.filter { STABLE == it }.count() }
        .groupBy { it.second }

    if (fullStringGrouped.size == 1) return 0


    //for to looping all sub words with current size
    for (size in 0 until s.length - 1) {
        //get all words with current size
        for (mainStart in 0..s.length - (size + 1)) {
            val word = s.substring(IntRange(mainStart, mainStart + size))
            for (subStart in 0..s.length - (size + 1)) {
                //ignore when the word is the same that the sub word
                val subWord = s.substring(IntRange(subStart, subStart + word.length - 1))
                if (!checkedWords.contains(subWord)) {
                    checkedWords.add(subWord)
                    val geneCut = s.replaceFirst(subWord, "")
                    val grouped = GENE_OPTIONS.map { STABLE -> STABLE.toString() to geneCut.filter { STABLE == it }.count() }.sortedByDescending { it.second }

                    val max = grouped[0].second
                    var diff = 0
                    for (i in 1 until grouped.size) {
                        diff += max - grouped[i].second
                    }

                    println("STAGE")
                    println("subWord: $subWord")
                    println("geneCut: $geneCut")
                    println("grouped: $grouped")
                    println("subWordSize: ${subWord.length}")
                    println("diff: $diff")
                    println("---------")
                    println("")

                    if (subWord.length == diff ||
                        (subWord.length > diff &&
                                (subWord.length - diff % 4 == 0))) {
                        return subWord.length
                    }

                }
            }
        }
    }

    return s.length
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//    val n = scan.nextLine().trim().toInt()
//    val gene = scan.nextLine()

    val gene = "GAAATAAA"
//    val gene = "TATATAGCTTGTCTCCCTAATGTTAGTTCATGCTCGTAAGAGAACTTAGCCTACTAGGACGAGAGAACCGCACGGCGTCGTGAGGTATTTTTCGTAGGACACGCCAGATAGACGGTGGCAATGCCCGTTCAATATGACGCGATGTACGGCTAATGGGAACACTGCCCGACGCGTCTTTAGGACTGTGAGTTGCGGGTTACAGCTATGGTCTTATTGGTATCCGGCCCCTTTCGAGTCGCGATGCGCCTGCCACCACGATATTCGCCCGAAACGCGATTTGTGGGCGAGGTAGTCGTGTTCAACCCTGTAAATTTCCCTAGGTATAATCGTTCTAAGGTTCGCACATACACATCCACACCTACCTTTACACAGTTCGAGGTTCTATACGTCCTCTGAGTGCGTGTTAACACGCCCGTAAATGGGCATTTGGAGTCAGACCAGTACTTTGCGATAAACTTTACTTCCGCGAGACCTGTCCCTGGAACCCTGTTGTAAGGGTTAGGGTTTAATAGCTCCATGTCGTGTGCCTATAAGAAAAGGACGAATGGTGACAGTCCGGCTTAGCCAGGACAATGCGTGGCTGACGACGTCCAGGGTAAATTGAGTTGAATTCGCCTAATTTTAGGGTGTCTTGGTTCAATGAGGTGTCGACTTAACAAAAGGCGACATCAGTTGTCATCTTGCCTTGATAAAGTAAAACACGTGAATAGCCTATCCGGTCTGACCCCCGGGCCATGTGCTTCACCCAGGGAGCATCGCCGCTCTAGAGACGGTGTTCGTAGTCTCGATAACATGTGGGGTAATATAGAATATCCAAGACCGGTAGGAGGGGCGGTTCCGCGTCATAAGAAGTCCCAACGTGGCCTGCCACGTTCAAACAGGATACGCTATAACAGCTTCGTGGGTAATTGATGGATACGCCCGCAGGCTACCCATGCTCTTGCGATTTTGCAACCCTCGGAACCGTCACTCGTACACCCAGACATCATCTCATACAATTGCCTCACCTTCATGCCGGTACATAGGTGCCATCTCCGCTTAAGAATCCTCGCAGCAATTAATGTGACAGCACGCTAGTCCACTAGCGTATGATTACGCCACCGGGCCACCATGGACAAAAACGTTGAATTCCGACTAATAGACGAGTGTCCGATCGGGTCAACCGATCTCGGATGTTGCGTACCAGGACTACTGGGCTCGGGCCGAATCAGACACACGTATGCAACAGATACCGATAGGCGTCTTCCTAAGTAACAGCCGTAATCAATGGTGCCACAGATCTACTAATTACGGTGAAGATCATGGCCCACGACGCTGTACGGGTTTATAGCTGCCACAAACTTTAGGAAGTTTCAGCAATCGACGCGTAGTATGTGTGCTCAGACGGGTCGAGCATGCACTTGTGTATTAAGTTACTTGGCTGAACAACCTGTTGATAGATCTTGAGAGGACCGAGAAATTGCCCTCCGGTTATGAAACAGGTCCTGCGTACCAATCCTT"

    val result = steadyGene(gene)

    println(result)
}
