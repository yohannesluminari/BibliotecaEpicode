package BibliotecaYL;

import java.io.*; // fornisce classi per l'input e l'output
import java.util.*; // List, Set, Map....


public class Biblioteca {
    //definisco un campo di istanza chiamato catalogo all'interno della classe Biblioteca
    private List<ElementoCatalogo> catalogo;

    // catalogo viene inizializzato come una lista vuota
    public Biblioteca() {
        this.catalogo = new ArrayList<>();
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String isbn) {
        catalogo.removeIf(e -> e.getIsbn().equals(isbn));
    }

    public ElementoCatalogo ricercaPerISBN(String isbn) {
        return catalogo.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }


    public List<ElementoCatalogo> ricercaPerAnnoPubblicazione(int anno) {
        List<ElementoCatalogo> risultato = new ArrayList<>();
        for (ElementoCatalogo e : catalogo) {
            if (e.getAnnoPubblicazione() == anno) {
                risultato.add(e);
            }
        }
        return risultato;
    }

    public List<ElementoCatalogo> ricercaPerAutore(String autore) {
        List<ElementoCatalogo> risultato = new ArrayList<>();
        for (ElementoCatalogo e : catalogo) {
            if (e instanceof Libro && ((Libro) e).getAutore().equals(autore)) {
                risultato.add(e);
            }
        }
        return risultato;
    }



    public void salvataggioSuDisco(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(catalogo);
        }
    }

    public void caricamentoDaDisco(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            catalogo = (List<ElementoCatalogo>) in.readObject();
        }
    }
}
