package main.java.entità;

import main.java.entità.Utente;

public interface UtenteDAO {
    void aggiungiUtente(Utente utente);
    void rimuoviUtente(String numeroTessera);
    Utente ricercaPerNumeroTessera(String numeroTessera);
    // Altri metodi per la gestione degli utenti
}
