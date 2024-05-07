package main.java.DAO;


import main.java.entità.Libro;

public interface LibroDAO {
    void aggiungiLibro(Libro libro);
    void rimuoviLibro(String isbn);
    Libro ricercaPerISBN(String isbn);

}
