package interfaces

interface IOiseau : IAnimal {

    enum class Habitat {
        PETITE_CAGE,
        VOLIAIRE
    }

    val couleur: String
    val habitat: Habitat
}