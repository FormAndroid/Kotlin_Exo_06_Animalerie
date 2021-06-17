package interfaces

import java.time.LocalDate

interface IPensionnaire {

    val animal: IAnimal
    val dateArrivee: LocalDate

    fun debuterJour(): Unit
    fun debuterNuit(): Unit
}

