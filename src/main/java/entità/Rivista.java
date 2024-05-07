
package  main.java.entità;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import main.java.BibliotecaYL.ElementoCatalogo;
import jakarta.persistence.Entity;

@Entity
@Table(name = "riviste")
//rivista è una sttoclasse della classe astratta ElementoCatalogo che rappresenta un elemento del catalogo di una biblioteca
public class Rivista extends ElementoCatalogo {
    @Id
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private String periodicita;


    // Definisci la relazione con l'utente
    @ManyToOne
    private Utente utente;


    // attraverso un enum che verrà poi sottoposto ad uno switch nel main rappresenta la peridocita di pubblicazuone della rivista
    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", periodicita='" + periodicita + '\'' +
                ", utente=" + utente +
                '}';
    }

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String isbn1, String titolo1, int annoPubblicazione1, int numeroPagine1, String periodicita, Utente utente) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.isbn = isbn1;
        this.titolo = titolo1;
        this.annoPubblicazione = annoPubblicazione1;
        this.numeroPagine = numeroPagine1;
        this.periodicita = periodicita;
        this.utente = utente;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicita) {
        this.periodicita = periodicita;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
