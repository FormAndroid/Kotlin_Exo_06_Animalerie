package models

import interfaces.IAnimal
import interfaces.IChat
import interfaces.IPensionnaire

class Animalerie {

    // Backing property
    private val _pensionnaires: MutableSet<IPensionnaire>

    // Properties
    val pensionnaires : List<IPensionnaire>
        get() = _pensionnaires.toList()

    // Constructor
    constructor() {
        this._pensionnaires = mutableSetOf()
    }

    // Methodes
    fun ajouterAnimal(animal: IAnimal) {
        val p = Pensionnaire(animal)

        if(pensionnaires.contains(p)) // Utilisation de la liste, car le contains de celui-ci utilise la méthode "equals"
            throw IllegalArgumentException("Le pensionnaire est déjà dans l'animalerie")

        this._pensionnaires.add(p)
    }

    fun simulationJournee() {
        println("Debut de journée")
        for(p in _pensionnaires) {
            p.debuterJour()

            if(p.animal is IChat && !(p.animal as IChat).griffesCoupees) {
                println("${p.animal.nom} griffe une personne :o")
            }
        }

        println("Fin de journée")
        for(p in _pensionnaires) {
            p.debuterNuit()

            if(p.animal.estVivant && p.animal is IChat && !(p.animal as IChat).griffesCoupees) {
                (p.animal as IChat).couperLesGriffes()
                println("On coupe les griffes de ${p.animal.nom} ")
            }

            if(!p.animal.estVivant) {
                println("${p.animal.nom} est mouru !")
            }
        }

        // Retrait des animaux mort
        // _pensionnaires.removeIf { p -> !p.animal.estVivant }
        _pensionnaires.removeIf { !it.animal.estVivant }
    }
}