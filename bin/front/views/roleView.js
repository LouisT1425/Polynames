import { addPlayer } from '../services/role.js';

document.getElementById("chooseRoleButton").addEventListener("click", () => {
    const pseudo = document.getElementById("pseudo").value;
    const role = document.getElementById("role").value;
    const partieCode = localStorage.getItem('partieCode');

    if (pseudo === '') {
        alert('Veuillez entrer un pseudo');
        return;
    }

    if (!partieCode) {
        alert("ID de la partie non trouvé.");
        return;
    }

    addPlayer(pseudo, role, partieCode)
        .then(() => {
            alert("Joueur ajouté avec succès !");
            window.location.href = "index.html";
        })
        .catch(error => {
            alert(error.message);
        });
});
