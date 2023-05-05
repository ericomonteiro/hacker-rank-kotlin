package design_patterns.chain_responsability

interface IFileDecoder {
    fun decode(path: String): Result<String>

    fun isCorrectExtension(path: String): Boolean
}