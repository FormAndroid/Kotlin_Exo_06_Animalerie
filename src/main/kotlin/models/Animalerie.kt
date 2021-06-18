package models

import interfaces.IAnimal
import interfaces.IChat
import interfaces.IOiseau
import interfaces.IPensionnaire
import java.util.*

class Animalerie {

    // Event Listener
    private val simulationEventListener: (String) -> Unit

    // Backing property
    private val _pensionnaires: MutableSet<IPensionnaire>

    // Properties
    val pensionnaires : List<IPensionnaire>
        get() = _pensionnaires.toList()

    // Constructor
    constructor(simulationEventListener: (String) -> Unit) {
        this._pensionnaires = mutableSetOf()
        this.simulationEventListener = simulationEventListener
    }

    // Methodes
    fun ajouterAnimal(animal: IAnimal) {
        // Ajout des listener sur l'animal
        animal.setDeathEventListener { a -> simulationEventListener("${a.nom} est mouru !") }
        if(animal is IOiseau) {
            animal.setSingEventListener { chanson -> simulationEventListener(chanson) }
        }

        // Création du pensionnaire de l'animalerie
        val p = Pensionnaire(animal)

        if(pensionnaires.contains(p)) // Utilisation de la liste, car le contains de celui-ci utilise la méthode "equals"
            throw IllegalArgumentException("Le pensionnaire est déjà dans l'animalerie")


        // Ajout du pensionnaire dans l'animalerie
        this.simulationEventListener("Nouvelle arrivant : ${animal.nom}")
        this._pensionnaires.add(p)
    }

    fun simulationJournee() {
        simulationEventListener("- Debut de journée")
        for(p in _pensionnaires) {
            p.debuterJour()

            if(p.animal is IChat && !(p.animal as IChat).griffesCoupees) {
                simulationEventListener("${p.animal.nom} griffe une personne :o")
            }
        }

        println("- Fin de journée")
        for(p in _pensionnaires) {
            p.debuterNuit()

            if(p.animal.estVivant && p.animal is IChat && !(p.animal as IChat).griffesCoupees) {
                (p.animal as IChat).couperLesGriffes()
                simulationEventListener("On coupe les griffes de ${p.animal.nom} ")
            }
        }

        // Retrait des animaux mort
        // _pensionnaires.removeIf { p -> !p.animal.estVivant }
        _pensionnaires.removeIf { !it.animal.estVivant }
    }
}