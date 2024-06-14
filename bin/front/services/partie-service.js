export class PartieService {
    constructor() {}

    static async getPartieIDFromPartieCode(partieCode){
        // Renvoie l'id de la partie(partieID dans la bdd) à partir d'un code de partie.
        try {
            const response = await fetch(`http://localhost:8080/getPartieIDFrom/${partieCode}`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            console.log('partieID:', data);
            return data;
        } catch (error) {
            console.error('There was a problem with the fetch operation:', error);
        }
    }
}