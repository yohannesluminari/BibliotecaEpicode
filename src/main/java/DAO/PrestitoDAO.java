package main.java.DAO;


import main.java.entità.Prestito;

public interface PrestitoDAO {
    void aggiungiPrestito(Prestito prestito);
    void rimuoviPrestito(int id);
    Prestito ricercaPerID(int id);
    // Altri metodi per la gestione dei prestiti
}
