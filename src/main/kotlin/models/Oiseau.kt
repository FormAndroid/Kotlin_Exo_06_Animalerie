package models

import interfaces.IAnimal
import interfaces.IOiseau

class Oiseau : Animal, IOiseau{

    //region EventListener
    private var singEventListener: ((String) -> Unit)? = null

    override fun setSingEventListener(listener: (String) -> Unit) {
        singEventListener = listener
    }
    //endregion

    override val couleur: String
    override val habitat: IOiseau.Habitat

    override val probaDeces: Double
        get() = 3.0

    constructor(
        nom: String, poids: Double, taille: Double, sexe: IAnimal.Sexe,
        couleur: String, habitat: IOiseau.Habitat
    ) : super(nom, poids, taille, sexe) {
        this.couleur = couleur
        this.habitat = habitat
    }

    override fun crier(): String {
        return "Chip chip"
    }

    fun chanter() {
        val limite = (1..3).random()

        val builder: StringBuilder = StringBuilder()
        for (x in 0 until limite) {
            builder.append(crier()).append(" ")
        }

        // Déclancher l'event (Si celui-ci n'est pas null)
        singEventListener?.invoke("$nom: ${builder.toString()}")
    }

    override fun activiteMatin() {
        chanter()
        super.activiteMatin()
    }

    override fun activiteSoir() {
        chanter()
        super.activiteSoir()
    }

    override fun equals(other: Any?): Boolean {
        return other is IOiseau
                && super.equals(other)
                && this.couleur == other.couleur
    }
}
