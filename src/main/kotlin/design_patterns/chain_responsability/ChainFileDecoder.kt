package design_patterns.chain_responsability

import java.lang.RuntimeException

object ChainFileDecoder {
    private val decoders: List<IFileDecoder> =
            listOf(
                    TxtDecoder(),
                    XmlDecoder()
            )

    fun decode(path: String): Result<String> {
        decoders.forEach { decoder ->
            if (decoder.isCorrectExtension(path)) {
                return decoder.decode(path)
            }
        }

        return Result.failure(RuntimeException("invalid extension"))
    }

}