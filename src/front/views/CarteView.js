import { CardsService } from '../services/carte-service.js';
import { CartesChoisiesService } from '../services/cartes-choisies-service.js';

export async function displayCards(partieID) {
    // Affiche les cartes sur la page principale.
    try {
        const carteIDs = await CartesChoisiesService.getCarteIDByPartieID(partieID); // fetch les id des cartes associées à la partie actuelle.
        const allCards = await CardsService.findAll(); // fetch l'ensemble des cartes.

        const selectedCards = [];
        for (let i = 0; i < allCards.length; i++) { // Filtre les cartes en comparant le carteID des cartes associées à la partie actuelle et le carteID de celles de la bdd.
            if (carteIDs.includes(allCards[i].carteID)) {
                selectedCards.push(allCards[i]);
            }
        } 
        
        const cardsContainer = document.getElementById('cards-container');
        
        const table = document.createElement('table');
        table.className = 'cards-table'; //classe
        
        for (let i = 0; i < 5; i++) { // Pour l'affichage en tableau
            const row = document.createElement('tr');
            for (let j = 0; j < 5; j++) {
                const cell = document.createElement('td');
                cell.className = 'card-cell';
                
                const cardIndex = i * 5 + j;
                if (cardIndex < selectedCards.length) {
                    const cardContainer = document.createElement('div');
                    cardContainer.className = 'card-container';
                    cardContainer.textContent = selectedCards[cardIndex].mot;
                    cell.appendChild(cardContainer);
                }
                
                row.appendChild(cell);
            }
            table.appendChild(row);
        }
        
        cardsContainer.appendChild(table);
    } catch (error) {
        console.error('Error fetching cards:', error);
    }
}
