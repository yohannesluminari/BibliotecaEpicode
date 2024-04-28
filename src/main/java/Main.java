
import BibliotecaYL.Biblioteca;
import  BibliotecaYL.Libro;
import  BibliotecaYL.Rivista;
import  BibliotecaYL.ElementoCatalogo;

import java.util.Scanner;
import java.io.IOException;
import java.util.List;

public class Main {
    static final int NUMERO_ARTICOLI = 3;


    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);


        // Aggiunta di  NUMERO_ARTICOLI libri Chiedi all'utente di inserire i dettagli dei libri
        for (int i = 1; i <= NUMERO_ARTICOLI; i++) {
            System.out.println("Inserisci i dettagli del libro " + i);
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("Autore: ");
            String autore = scanner.nextLine();
            System.out.print("Genere: ");
            String genere = scanner.nextLine();
            System.out.print("Anno di pubblicazione: ");
            int annoPubblicazione = Integer.parseInt(scanner.nextLine());
            System.out.print("Numero di pagine: ");
            int numeroPagine = Integer.parseInt(scanner.nextLine());

            Libro libro = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
            biblioteca.aggiungiElemento(libro);
        }

        // Aggiunta di NUMERO_ARTICOLI riviste
        for (int i = 1; i <= NUMERO_ARTICOLI; i++) {
            System.out.println("Inserisci i dettagli della rivista " + i);
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("Anno di pubblicazione: ");
            int annoPubblicazione = Integer.parseInt(scanner.nextLine());
            System.out.print("Numero di pagine: ");
            int numeroPagine = Integer.parseInt(scanner.nextLine());
            System.out.print("Periodicita (1 per SETTIMANALE, 2 per MENSILE, 3 per SEMESTRALE o nome completo della periodicita): ");
            String inputPeriodicita = scanner.nextLine();
            Rivista.Periodicita periodicita;

            // uso uno switch per rentare nei 3 casi
            switch (inputPeriodicita.toUpperCase()) {
                case "1":
                case "SETTIMANALE":
                    periodicita = Rivista.Periodicita.SETTIMANALE;
                    break;
                case "2":
                case "MENSILE":
                    periodicita = Rivista.Periodicita.MENSILE;
                    break;
                case "3":
                case "SEMESTRALE":
                    periodicita = Rivista.Periodicita.SEMESTRALE;
                    break;
                default:
                    // Se l'input non corrisponde a nessuna periodicità nota, usa SEMESTRALE come valore predefinito
                    periodicita = Rivista.Periodicita.SEMESTRALE;
                    break;
            }


            Rivista rivista = new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodicita);
            biblioteca.aggiungiElemento(rivista);
        }


        // // Ricerca per ISBN --- usare isbn 1(ovviamneto prima toccherebbe inserire un libro o rivista con questo isbn) non automatico ma staatico
        // ElementoCatalogo elemento = biblioteca.ricercaPerISBN("1"); // Cambia l'ISBN se necessario
        // if (elemento != null) {
        //     System.out.println("Ricerca per ISBN: " + elemento.getTitolo());
        // } else {
        //     System.out.println("Nessun elemento trovato per l'ISBN specificato.");
        // }

        // Ricerca per ISBN dinamica con interazione utente1
        System.out.println("Inserisci l'ISBN per cercare un elemento:");
        String isbnCercato = scanner.nextLine();
        ElementoCatalogo elemento = biblioteca.ricercaPerISBN(isbnCercato);
        if (elemento != null) {
            System.out.println("Elemento trovato: " + elemento.getTitolo());
        } else {
            System.out.println("Nessun elemento trovato per l'ISBN specificato.");
        }

        // Rimozione di un elemento statico
        // biblioteca.rimuoviElemento("123-4-56-789012-3");

        // Rimozione di un elemento
        System.out.println("Inserisci l'ISBN dell'elemento da rimuovere:");
        String isbnDaRimuovere = scanner.nextLine();
        biblioteca.rimuoviElemento(isbnDaRimuovere);
        System.out.println("Elemento rimosso con successo, se presente nel catalogo.");


        // Ricerca per anno di pubblicazione di elmento1
        System.out.println("Inserisci l'anno di pubblicazione da cercare:");
        int annoDaCercare = Integer.parseInt(scanner.nextLine());
        List<ElementoCatalogo> risultatoRicercaAnno = biblioteca.ricercaPerAnnoPubblicazione(annoDaCercare);
        if (!risultatoRicercaAnno.isEmpty()) {
            System.out.println("Risultato della ricerca per anno di pubblicazione " + annoDaCercare + ":");
            for (ElementoCatalogo elemento1 : risultatoRicercaAnno) {
                System.out.println("- " + elemento1.getTitolo());
            }
        } else {
            System.out.println("Nessun elemento trovato per l'anno di pubblicazione specificato.");
        }

        // Ricerca per autore
        System.out.println("Inserisci l'autore da cercare:");
        String autoreDaCercare = scanner.nextLine();
        List<ElementoCatalogo> risultatoRicercaAutore = biblioteca.ricercaPerAutore(autoreDaCercare);
        if (!risultatoRicercaAutore.isEmpty()) {
            System.out.println("Risultato della ricerca per autore " + autoreDaCercare + ":");
            for (ElementoCatalogo elemento1 : risultatoRicercaAutore) {
                System.out.println("- " + elemento1.getTitolo());
            }
        } else {
            System.out.println("Nessun elemento trovato per l'autore specificato.");
        }

        // Salvataggio su disco dell'archivio
        System.out.println("Inserisci il nome del file per il salvataggio:");
        String fileSave = scanner.nextLine();
        try {
            biblioteca.salvataggioSuDisco(fileSave);
            System.out.println("Archivio salvato con successo su disco.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio su disco: " + e.getMessage());
        }

        // Caricamento dal disco dell'archivio in una nuova lista
        System.out.println("Inserisci il nome del file per il caricamento:");
        String fileLoad = scanner.nextLine();
        try {
            biblioteca.caricamentoDaDisco(fileLoad);
            System.out.println("Archivio caricato con successone.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Si è verificato un errore riprova fratello: " + e.getMessage());
        }
    }
}
