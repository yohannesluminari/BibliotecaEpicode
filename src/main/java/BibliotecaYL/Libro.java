package BibliotecaYL;

public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        //super --> richiama il costruttore della classe genitore ElementoCatalogo e viene fatto per inizializzare correttamente gli attributi ereditati dalla classe genitore
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }
}
