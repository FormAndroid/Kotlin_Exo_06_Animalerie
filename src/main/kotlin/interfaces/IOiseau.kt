package interfaces

interface IOiseau : IAnimal {

    // EventListener
    fun setSingEventListener(listener: (String) -> Unit)

    // Enum
    enum class Habitat {
        PETITE_CAGE,
        VOLIAIRE
    }

    // Properties
    val couleur: String
    val habitat: Habitat
}
