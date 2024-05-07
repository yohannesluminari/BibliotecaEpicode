package main.java.entità;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String numeroTessera;

    // Definisco le relazioni con libri e riviste
    @OneToMany(mappedBy = "utente")
    private List<Libro> libriInPrestito;

    @OneToMany(mappedBy = "utente")
    private List<Rivista> rivisteInPrestito;

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroTessera='" + numeroTessera + '\'' +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public Utente(String nome, String cognome, Date dataNascita, String numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }
}