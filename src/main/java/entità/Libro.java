package main.java.entità;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import main.java.BibliotecaYL.ElementoCatalogo;
import jakarta.persistence.Entity;

@Entity
@Table(name = "libri")
public class Libro extends ElementoCatalogo {
    @Id
    private String isbn;
    private String titolo;
    private String autore;
    private String genere;
    private int annoPubblicazione;
    private int numeroPagine;

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String isbn1, String titolo1, String autore, String genere, int annoPubblicazione1, int numeroPagine1, Utente utente) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.isbn = isbn1;
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.annoPubblicazione = annoPubblicazione1;
        this.numeroPagine = numeroPagine1;
        this.utente = utente;
    }

    // Definisco la relazione con l'utente
    @ManyToOne
    private Utente utente;

    @Override
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", utente=" + utente +
                '}';
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
