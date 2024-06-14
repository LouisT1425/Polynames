import { createGame, joinGame } from '../welcome.js';

document.getElementById("createGameButton").addEventListener("click", async () => {
    try {
        const success = await createGame();
        if (success) {
            window.location.href = 'role.html';
        }
    } catch (error) {
        alert(error.message);
    }
});


document.getElementById("joinGameButton").addEventListener("click", async () => { // Pas implémenté
    const pseudo = document.getElementById('pseudo').value;
    try {
        const success = await joinGame(pseudo);
        if (success) {
            alert('Partie rejointe avec succès');
            window.location.href = 'role.html';
        }
    } catch (error) {
        alert(error.message);
    }
});
