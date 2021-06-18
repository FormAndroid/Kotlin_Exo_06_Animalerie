package models

import interfaces.IAnimal

// Utilisation du constructeur secondaire
abstract class Animal: IAnimal {

    //region EventListener
    private var deathEventListener: ((IAnimal) -> Unit)? = null

    override fun setDeathEventListener(listener: (IAnimal) -> Unit) {
        deathEventListener = listener
    }
    //endregion

    // Le mot clef "final" bloque l'override dans les classes enfants
    final override val nom: String
    final override var poids : Double
    final override var taille: Double
    final override val sexe: IAnimal.Sexe

    final override var estVivant: Boolean
        private set(value) {
            if(!value) {
                deathEventListener?.invoke(this)
            }

            field = value
        }

    protected abstract val probaDeces : Double          // Exemple: 0.5% / 1% / 3%

    constructor(nom: String, poids: Double, taille: Double, sexe: IAnimal.Sexe) {
        this.nom = nom
        this.poids = poids
        this.taille = taille
        this.sexe = sexe

        this.estVivant = true
    }

    abstract override fun crier() : String

    fun risqueMourir() {
        val proba = ((0 .. 10000).random()) / 100.0      // -> 0.25, 0.81, 10.5

        estVivant = proba > probaDeces
    }

    override fun activiteMatin() {
    }

    override fun activiteSoir() {
        risqueMourir()
    }

    override fun equals(other: Any?): Boolean {
        return other is IAnimal
                && this.nom == other.nom
                && this.poids == other.poids
                && this.taille == other.taille
                && this.sexe == other.sexe
    }
}




// Version incomplete, pour la demo du constructeur primaire
/*
class Animal(
    override val nom: String,
    override var poids: Double,
    override var taille: Double,
    override val sexe: IAnimal.Sexe
) : IAnimal {

    override var estVivant: Boolean = true
        private set
}
*/