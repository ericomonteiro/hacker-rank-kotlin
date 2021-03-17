package algorithms

import java.util.Date

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

// Complete the sherlockAndAnagrams function below.

var cachedStrings = mutableMapOf<String, Int>()
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
    val s1Array = this.toCharArray()
    val s2Array = s.toCharArray()

    val i1Array = s1Array.map { it.toInt() }
    val i2Array = s2Array.map { it.toInt() }

    return if (i1Array.sum() == i2Array.sum()) {
        val sorted1 = s1Array.sorted()
        val sorted2 = s2Array.sorted()
        for (i in sorted1.indices) {
            if (sorted1[i] != sorted2[i])
                return false
        }
        return true
    } else false
}

fun main(args: Array<String>) {
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
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        "bbcaadacaacbdddcdbddaddabcccdaaadcadcbddadababdaaabcccdcdaacadcababbabbdbacabbdcbbbbbddacdbbcdddbaaa",
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        "cacccbbcaaccbaacbbbcaaaababcacbbababbaacabccccaaaacbcababcbaaaaaacbacbccabcabbaaacabccbabccabbabcbba",
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        "bbcbacaabacacaaacbbcaabccacbaaaabbcaaaaaaaccaccabcacabbbbabbbbacaaccbabbccccaacccccabcabaacaabbcbaca",
        "cbaacdbaadbabbdbbaabddbdabbbccbdaccdbbdacdcabdbacbcadbbbbacbdabddcaccbbacbcadcdcabaabdbaacdccbbabbbc",
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        "babacaccaaabaaaaaaaccaaaccaaccabcbbbabccbbabababccaabcccacccaaabaccbccccbaacbcaacbcaaaaaaabacbcbbbcc",
        "bcbabbaccacbacaacbbaccbcbccbaaaabbbcaccaacaccbabcbabccacbaabbaaaabbbcbbbbbaababacacbcaabbcbcbcabbaba"
    )

//    val inputs = listOf("ifailuhkqq")

    val start = Date().time
    inputs.forEach {
        val init = Date().time
        println(it)
        println(sherlockAndAnagrams(it))
        println("tempo - ${Date().time - init}")
    }
    println("time = ${Date().time - start}")
}
