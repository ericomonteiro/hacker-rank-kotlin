val pairs = mapOf(
    '(' to ')',
    '[' to ']',
    '{' to '}'
)


fun main() {
    val exps = listOf(
        "()",
        "(([]))",
        "(()",
        "[]",
        "([{]})",
        "{}[]()",
        ""
    )

    exps.forEach { expression ->
        println("$expression=${ expression.toCharArray().validExpression() }")
    }
}

fun CharArray.validExpression(): Boolean {
    if (this.isEmpty()) return false

    //--- se a expressão possui uma quantidade ímpar de caracteres é inválida
    if (this.size % 2 != 0) return false

    //--- retorna o índice do carácter fechando a extremidade e a expressão entre a abertura e fechamento
    val (indexEnding, subExpression) = this.findIndexOfEndingExp(0)

    //--- caso não encontrou fechamento expressão é inválida
    if (indexEnding == -1) return false

    //--- se existe sub-expressão e ela é inválida a expressão como um todo é inválida
    if (subExpression.isNotEmpty() && !subExpression.validExpression()) return false

    //--- se o fechamento da expressão encontrada não está no último carácter validar final da expressão
    if (indexEnding != lastIndex() && !this.copyOfRange(indexEnding + 1, size).validExpression()) return false

    return true
}

fun CharArray.lastIndex() = size - 1

fun Char.isOpening() = "({[".contains(this)

fun CharArray.findIndexOfEndingExp(indexStart: Int): Pair<Int, CharArray> {
    val currentChar = this[indexStart]
    val defaultReturn = Pair(-1, charArrayOf())

    //--- Se o primeiro carácter é de fechamento e não é o fechamento do que está em análise a expressão é inválida
    if (!currentChar.isOpening() && currentChar != this[indexStart]) return defaultReturn

    var contSameOpenChar = 0
    for (i in indexStart + 1 until this.size) {
        val chr = this[i]

        //--- repetindo o carácter de abertura
        if (chr == currentChar) contSameOpenChar++

        if (chr == pairs[currentChar]) {
            //--- se não foi aberto mais de uma vez e encontramos o par, foi encontrado onde esta sendo fechado
            if (contSameOpenChar == 0) {
                return Pair(i, this.copyOfRange(indexStart + 1, i))
            }

            //--- encontrou um fechamento do mesmo carácter
            contSameOpenChar--
        }
    }

    return defaultReturn
}
