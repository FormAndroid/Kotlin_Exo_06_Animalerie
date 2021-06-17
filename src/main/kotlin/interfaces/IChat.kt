package interfaces

interface IChat : IAnimal {

    enum class Poil {
        COURT,
        LONG
    }

    val poil: Poil
    val caractere: String

    val griffesCoupees: Boolean

    fun couperLesGriffes(): Unit
    // Unit -> Procedure (Equivalent void)
}