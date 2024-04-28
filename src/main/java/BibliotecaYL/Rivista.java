package BibliotecaYL;

//rivista è una sttoclasse della classe astratta ElementoCatalogo che rappresenta un elemento del catalogo di una biblioteca
public class Rivista extends ElementoCatalogo {
    // attraverso un enum che verrà poi sottoposto ad uno switch nel main rappresenta la peridocita di pubblicazuone della rivista
    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }


    // private ovviam,ente per garantire l'incapsulamento  dei dati
    private Periodicita periodicita;

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }
}
