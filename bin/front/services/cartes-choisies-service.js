// services/cartes-choisies-service.js

export class CartesChoisiesService {
    constructor() {}

    static async addCarteToPartie(partieID, carteID) {
        // Associe une carte à une partie via les ID.
        const response = await fetch(`http://localhost:8080/addCarte/${partieID}/${carteID}`, {
            method: 'POST',
        });
        if (response.ok) {
            console.log("OK")
            return 'Carte added successfully to partie';
        } else {
            throw new Error('Failed to add carte to partie');
        }
    }

    static async drawCards(partieID){
        // Tire 25 cartes aléatoires de la BDD et les associent à une partie.
        try {
            const response = await fetch(`http://localhost:8080/drawCards/${partieID}`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            console.log('Cartes choisies:', data);
            return data;
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    }

    static async getCarteIDByPartieID(partieID) {
        // Renvoie les cartes associées à une partie.
        try {
            const response = await fetch(`http://localhost:8080/getCarteID/${partieID}`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            console.log('Cartes choisies:', data);
            return data;
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    }
}
