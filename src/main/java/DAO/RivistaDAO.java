package main.java.DAO;

import main.java.entità.Rivista;

public interface RivistaDAO {
    void aggiungiRivista(Rivista rivista);
    void rimuoviRivista(String isbn);
    Rivista ricercaPerISBN(String isbn);

}