package design_patterns.chain_responsability

import java.io.File

class XmlDecoder: IFileDecoder {

    override fun decode(path: String): Result<String> {
        return Result.success("xml to json")
    }

    override fun isCorrectExtension(path: String): Boolean {
        return File(path).extension.uppercase() == "XML"
    }
}