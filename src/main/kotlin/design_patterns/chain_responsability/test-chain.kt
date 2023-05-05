package design_patterns.chain_responsability

fun main() {
    val files = listOf(
            "abc.xml",
            "abc.txt",
            "abc.exe"
    )

    files.forEach { file ->
        ChainFileDecoder.decode(file)
                .onSuccess { decoded -> println(decoded) }
                .onFailure { ex -> println(ex.message) }
    }
}