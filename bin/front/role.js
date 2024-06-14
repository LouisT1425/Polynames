import { CartesChoisiesService } from './cartes-choisies-service.js';
import { PartieService } from './partie-service.js';

export function addPlayer(pseudo, role, partieCode) {
    return fetch(`http://localhost:8080/addPlayer/${pseudo}/${role}/${partieCode}`, {
        method: 'POST',
    })
    .then(response => {
        if (response.ok) {
            CartesChoisiesService.drawCards(PartieService(partieCode));
            return true;
        } else {
            throw new Error("Erreur lors de l'ajout du joueur.");
        }
    })
    .catch(error => {
        console.error("Erreur :", error);
        throw new Error("Erreur de connexion à l'API.");
    });
}
