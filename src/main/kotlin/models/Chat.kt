package models

import interfaces.IAnimal
import interfaces.IChat

class Chat : Animal, IChat {

    // Backing Property
    private var _griffes: Int

    // Properties
    override val poil: IChat.Poil
    override val caractere: String

    override val griffesCoupees: Boolean
        get() = _griffes < 10

    override val probaDeces: Double
        get() = 0.5

    // Constructor
    constructor(
        nom: String, poids: Double, taille: Double, sexe: IAnimal.Sexe,
        poil: IChat.Poil, caractere: String, griffesCoupees: Boolean = false
    ) : super(nom, poids, taille, sexe) {
        this.poil = poil
        this.caractere = caractere
        this._griffes = if(griffesCoupees) 0 else (1 .. 10).random()
    }

    // Methodes
    override fun crier(): String {
        return "Miaou !"
    }

    override fun couperLesGriffes() {
        this._griffes = 0
    }

    fun fairePousseGriffes() {
        this._griffes += 1
    }

    override fun activiteMatin() {
        super.activiteMatin()
        fairePousseGriffes()
    }


    override fun equals(other: Any?): Boolean {
        return other is IChat
                && super.equals(other)
                && this.caractere == other.caractere
                && this.poil == other.poil
    }
}