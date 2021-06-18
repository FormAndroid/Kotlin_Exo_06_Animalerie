package interfaces

interface IAnimal {

    // EventListener
    fun setDeathEventListener(listener: (IAnimal) -> Unit)

    // Enum
    enum class Sexe {
        M,
        F
    }

    // Properties
    val nom: String
    var poids: Double   // kg
    var taille: Double  // cm
    val sexe: Sexe
    val estVivant: Boolean

    // Function
    fun crier() : String
    fun activiteMatin()
    fun activiteSoir()
}