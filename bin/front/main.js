import { PartieService } from './services/partie-service.js';
import { displayCards } from './views/CarteView.js';

let idPartie = 1 // A changer selon l'id de la partie que l'on veut afficher
                // Il faut aller directement sur index.html pour voir les cartes associées à une partie.
                // La liaison entre welcome.html et role.html se fait bien comme il faut, mais la liaison
                // entre role.html et index.html ne marche pas à cause du CORS et je ne sais pas comment
                // résoudre le problème.
displayCards(idPartie);
