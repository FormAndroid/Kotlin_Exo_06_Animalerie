package interfaces

interface IAnimal {

    enum class Sexe {
        M,
        F
    }

    val nom: String
    var poids: Double   // kg
    var taille: Double  // cm
    val sexe: Sexe
    val estVivant: Boolean

    fun crier() : String
    fun activiteMatin()
    fun activiteSoir()
}