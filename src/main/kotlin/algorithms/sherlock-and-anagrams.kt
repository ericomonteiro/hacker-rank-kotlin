package algorithms

import java.math.BigDecimal
import java.util.Date

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

// Complete the sherlockAndAnagrams function below.

var cachedStrings = mutableMapOf<String, Int>()

val TEN = BigDecimal(10.0)
val mapCharToTenPow = mapOf(
    'a' to TEN.pow(1),
    'b' to TEN.pow(2),
    'c' to TEN.pow(3),
    'd' to TEN.pow(4),
    'e' to TEN.pow(5),
    'f' to TEN.pow(6),
    'g' to TEN.pow(7),
    'h' to TEN.pow(8),
    'i' to TEN.pow(9),
    'j' to TEN.pow(10),
    'k' to TEN.pow(11),
    'l' to TEN.pow(12),
    'm' to TEN.pow(13),
    'n' to TEN.pow(14),
    'o' to TEN.pow(15),
    'p' to TEN.pow(16),
    'q' to TEN.pow(17),
    'r' to TEN.pow(18),
    's' to TEN.pow(19),
    't' to TEN.pow(20),
    'u' to TEN.pow(21),
    'v' to TEN.pow(22),
    'w' to TEN.pow(23),
    'x' to TEN.pow(24),
    'y' to TEN.pow(25),
    'z' to TEN.pow(26)
)

fun sherlockAndAnagrams(s: String): Int {
    if (cachedStrings[s] != null) {
        return cachedStrings[s]!!
    }

    var countAnagrams = 0
    val anagramsChecked = mutableSetOf<Pair<Int, Int>>()

    //for to looping all sub words with current size
    for (size in 0 until s.length - 1) {
        anagramsChecked.clear()
        //get all words with current size
        for (mainStart in 0..s.length - (size + 1)) {
            val word = s.substring(IntRange(mainStart, mainStart + size))
            for (subStart in 0..s.length - (size + 1)) {
                //ignore when the word is the same that the sub word
                if (mainStart != subStart) {
                    val pair = Pair(minOf(mainStart, subStart), maxOf(mainStart, subStart))
                    if (!anagramsChecked.contains(pair)) {
                        val subWord = s.substring(IntRange(subStart, subStart + word.length - 1))
                        if (word.isAnagram(subWord)) {
                            anagramsChecked.add(pair)
                            countAnagrams++
                        }
                    }
                }
            }
        }
    }

    cachedStrings[s] = countAnagrams
    return countAnagrams
}



fun String.isAnagram(s: String): Boolean {
    val s1 = this.toCharArray()
    val s2 = s.toCharArray()

    return anagramFirstCheck(s1, s2)  && anagramSecondCheck(s1, s2)
}

fun anagramFirstCheck(s1: CharArray, s2: CharArray) =
    (s1.map {it.toInt()}.sum() == s2.map {it.toInt()}.sum())

fun anagramSecondCheck(s1: CharArray, s2: CharArray): Boolean {
    val s1DoubleArray = s1.map { mapCharToTenPow[it]!! }
    val s2DoubleArray = s2.map {  mapCharToTenPow[it]!!  }

    return (s1DoubleArray.fold(BigDecimal.ZERO, BigDecimal::add) == s2DoubleArray.fold(BigDecimal.ZERO, BigDecimal::add))
}

//simplest way to check if is anagram
fun anagramThirdCheck(s1: CharArray, s2: CharArray) = (s1.sorted() == s2.sorted())


fun main() {
//    val scan = Scanner(System.`in`)
//
//    val q = scan.nextLine().trim().toInt()
//
//    for (qItr in 1..q) {
//        val s = scan.nextLine()
//
//        val result = sherlockAndAnagrams(s)
//
//        println(result)
//    }

//    val inputs = listOf(
//        "dbcfibibcheigfccacfegicigcefieeeeegcghggdheichgafhdigffgifidfbeaccadabecbdcgieaffbigffcecahafcafhcdg",
//        "dfcaabeaeeabfffcdbbfaffadcacdeeabcadabfdefcfcbbacadaeafcfceeedacbafdebbffcecdbfebdbfdbdecbfbadddbcec",
//        "gjjkaaakklheghidclhaaeggllagkmblhdlmihmgkjhkkfcjaekckaafgabfclmgahmdebjekaedhaiikdjmfbmfbdlcafamjbfe",
//        "fdbdidhaiqbggqkhdmqhmemgljaphocpaacdohnokfqmlpmiioedpnjhphmjjnjlpihmpodgkmookedkehfaceklbljcjglncfal",
//        "bcgdehhbcefeeadchgaheddegbiihehcbbdffiiiifgibhfbchffcaiabbbcceabehhiffggghbafabbaaebgediafabafdicdhg",
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//        "mhmgmbbccbbaffhbncgndbffkjbhmkfncmihhdhcebmchnfacdigflhhbekhfejblegakjjiejeenibemfmkfjbkkmlichlkbnhc",
//        "fdacbaeacbdbaaacafdfbbdcefadgfcagdfcgbgeafbfbggdedfbdefdbgbefcgdababafgffedbefdecbaabdaafggceffbacgb",
//        "bahdcafcdadbdgagdddcidaaicggcfdbfeeeghiibbdhabdhffddhffcdccfdddhgiceciffhgdibfdacbidgagdadhdceibbbcc",
//        "dichcagakdajjhhdhegiifiiggjebejejciaabbifkcbdeigajhgfcfdgekfajbcdifikafkgjjjfefkdbeicgiccgkjheeiefje"
//    )

    val inputs = listOf(
        "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel",
        "gffryqktmwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjxbmxpnde",
        "mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw",
        "ofeqjnqnxwidhbuxxhfwargwkikjqwyghpsygjxyrarcoacwnhxyqlrviikfuiuotifznqmzpjrxycnqktkryutpqvbgbgthfges",
        "zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw",
    )

//    val inputs = listOf(
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//        "bbcaadacaacbdddcdbddaddabcccdaaadcadcbddadababdaaabcccdcdaacadcababbabbdbacabbdcbbbbbddacdbbcdddbaaa",
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//        "cacccbbcaaccbaacbbbcaaaababcacbbababbaacabccccaaaacbcababcbaaaaaacbacbccabcabbaaacabccbabccabbabcbba",
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//        "bbcbacaabacacaaacbbcaabccacbaaaabbcaaaaaaaccaccabcacabbbbabbbbacaaccbabbccccaacccccabcabaacaabbcbaca",
//        "cbaacdbaadbabbdbbaabddbdabbbccbdaccdbbdacdcabdbacbcadbbbbacbdabddcaccbbacbcadcdcabaabdbaacdccbbabbbc",
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//        "babacaccaaabaaaaaaaccaaaccaaccabcbbbabccbbabababccaabcccacccaaabaccbccccbaacbcaacbcaaaaaaabacbcbbbcc",
//        "bcbabbaccacbacaacbbaccbcbccbaaaabbbcaccaacaccbabcbabccacbaabbaaaabbbcbbbbbaababacacbcaabbcbcbcabbaba"
//    )

//    val inputs = listOf("ifailuhkqq")

    val start = Date().time
    inputs.forEach {
        val init = Date().time
//        println(it)
        println(sherlockAndAnagrams(it))
//        println("tempo - ${Date().time - init}")
    }
    println("time = ${Date().time - start}")
}
