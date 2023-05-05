package design_patterns.chain_responsability

import java.io.File

class TxtDecoder: IFileDecoder {

    override fun decode(path: String): Result<String> {
        return Result.success("txt to json")
    }

    override fun isCorrectExtension(path: String): Boolean {
        return File(path).extension.uppercase() == "TXT"
    }
}