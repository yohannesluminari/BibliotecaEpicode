package main.java.BibliotecaYL;

import java.io.Serializable;

// le sottoclassi Libro e Rivista estenderanno la classee di questa fuznionalità astratta
public abstract class ElementoCatalogo implements Serializable {
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;


    // creo il costrutto e setters e getters per le questa e le altre classi in modo da manipolare emglio i dati
    public ElementoCatalogo(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }
}
