package models

import interfaces.IAnimal
import interfaces.IChien

class Chien : Animal, IChien {

    override var couleurCollier: String
    override var estDresse: Boolean

    override val probaDeces: Double
        get() = 1.0

    constructor(
        nom: String, poids: Double, taille: Double, sexe: IAnimal.Sexe,
        couleurCollier: String, estDresse: Boolean
    ) : super(nom, poids, taille, sexe) {
        this.couleurCollier = couleurCollier
        this.estDresse = estDresse
    }

    override fun crier(): String {
        return "Whouf whouf"
    }

    override fun equals(other: Any?): Boolean {
        return other is IChien && super.equals(other)
    }
}






// Version incomplete, pour la demo du constructeur primaire avec héritage
/*
class Chien(nom: String, poids: Double,
             taille: Double, sexe: IAnimal.Sexe,
             override var couleurCollier: String,
             override var estDresse: Boolean
) : Animal(nom, poids, taille, sexe), IChien {

    override val probaDeces: Double
        get() = 1.0
}
*/