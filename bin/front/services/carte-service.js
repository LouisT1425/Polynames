// services/carte-service.js

export class CardsService {
    constructor() {}

    static async findAll() {
        // Renvoie toutes les cartes de la bdd.
        const response = await fetch("http://localhost:8080/Cartes");

        if (response.status === 200) {
            const data = await response.json();
            return data;
        } else {
            throw new Error(`Failed to fetch cards: ${response.status}`);
        }
    }

    static async randomCards() {
        // Renvoie 25 cartes aléatoires.
        const response = await fetch("http://localhost:8080/25Cartes");

        if (response.status === 200) {
            const data = await response.json();
            return data;
        } else {
            throw new Error(`Failed to fetch cards: ${response.status}`);
        }
    }
}
