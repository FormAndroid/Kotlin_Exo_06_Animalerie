import interfaces.IAnimal
import interfaces.IChat
import interfaces.IOiseau
import interfaces.IPensionnaire
import models.*
import java.time.LocalDate

fun main(args: Array<String>) {
    /*
    // Demo de l'utilisation de la surcharge du .equals
    val chat1: Chat = Chat("Le Chat", 4321.0, 40.0, IAnimal.Sexe.F, IChat.Poil.COURT, "Joueur")
    val chat2 : IAnimal = Chat("Le Chat", 4321.0, 40.0, IAnimal.Sexe.F, IChat.Poil.COURT, "Joueur")
    val chat3: IChat = chat1

    println("chat1 == chat2 -> ${chat1 == chat2}")
    println("chat1 == chat3 -> ${chat1 == chat3}")

    println("HashCode chat1 -> ${chat1.hashCode()}")
    println("HashCode chat2 -> ${chat2.hashCode()}")
    println("HashCode chat3 -> ${chat3.hashCode()}")
     */


    val animalerie: Animalerie = Animalerie()

    animalerie.ajouterAnimal(Chat("Le Chat", 4321.0, 40.0, IAnimal.Sexe.F, IChat.Poil.COURT, "Joueur"))
    animalerie.ajouterAnimal(Chat("Jacky", 12101.0, 70.0, IAnimal.Sexe.M, IChat.Poil.LONG, "Gourmant"))
    animalerie.ajouterAnimal(Chien("Rex", 500.0, 25.0, IAnimal.Sexe.M, "Rose bonbon", false))
    animalerie.ajouterAnimal(Oiseau("Titi", 100.0, 10.0, IAnimal.Sexe.F, "Jaune", IOiseau.Habitat.PETITE_CAGE))


    var jour = 1
    while(animalerie.pensionnaires.isNotEmpty()) {
        println("Jour $jour")

        println("Liste des animaux : ")
        for (p in animalerie.pensionnaires) {
            println(" - ${p.animal.nom}")
        }

        animalerie.simulationJournee()

        readLine()
        jour++
    }
    println("Fin de la simulation")
}