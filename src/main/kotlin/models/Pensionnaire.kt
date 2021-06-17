package models

import interfaces.IAnimal
import interfaces.IChat
import interfaces.IPensionnaire
import java.time.LocalDate

class Pensionnaire : IPensionnaire {

    override val animal: IAnimal
    override val dateArrivee: LocalDate

    constructor(animal: IAnimal) {
        this.animal = animal
        this.dateArrivee = LocalDate.now()
    }

    constructor(animal: IAnimal, dateArrivee: LocalDate) {
        this.animal = animal
        this.dateArrivee = dateArrivee
    }

    override fun debuterJour() {
        this.animal.activiteMatin()
    }

    override fun debuterNuit() {
        this.animal.activiteSoir()
    }


    override fun equals(other: Any?): Boolean {
        return other is IPensionnaire
                && this.animal == other.animal
                && this.dateArrivee == other.dateArrivee
    }
}

