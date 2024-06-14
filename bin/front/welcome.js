async function createGame() {
    try{
        const response = await fetch("http://localhost:8080/createGame", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (response.status === 200) {
            const data = await response.json();
            console.log(data);
            localStorage.setItem("partieCode", response.text());
            window.location.href = 'role.html';
        } else {
            const error = await response.text();
            alert('Erreur: ' + error);
        }
    } catch(error){
        alert('Erreur: ' + error.message);
    }

}

async function joinGame() {
    console.log("Fonction pas encore implémentée.")
}

window.createGame = createGame;
window.joinGame = joinGame;