public record Titolare(String nome, String cognome, String mail) {

    public Titolare(String nome, String cognome, String mail) {

        this.nome = nome;
        this.cognome = cognome;
        this.mail = (mail == null) ? "info@agriturismibenevento.it" : mail;
    }

    @Override
    public String toString() {

        return cognome + " " + nome + ", recapito: " + mail;
    }
}
