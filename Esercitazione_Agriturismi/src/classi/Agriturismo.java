package classi;

import java.util.Objects;

public class Agriturismo   {
    private String comune;
    private String titolare;
    private String denominazione;
    private String indirizzo;
    private int postiLetto;
    private int postiMacchina;
    private int postiTenda;
    private int postiRoulotte;
    private String recapito;
    private boolean pernottamento;
    private boolean isCamping;

    public Agriturismo(String comune, String titolare, String denominazione, String indirizzo, int postiLetto, int postiMacchina, int postiTenda, int postiRoulotte, String recapito) {
        this.comune = comune;

        this.titolare = titolare;

        this.denominazione = denominazione;

        this.indirizzo = indirizzo;

        this.postiLetto = postiLetto;

        this.postiMacchina = postiMacchina;

        this.postiTenda = postiTenda;

        this.postiRoulotte = postiRoulotte;

        this.recapito = recapito;
        this.pernottamento = false;
        this.isCamping=false;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getTitolare() {
        return titolare;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getPostiLetto() {
        return postiLetto;
    }

    public void setPostiLetto(int postiLetto) {
        this.postiLetto = postiLetto;
    }

    public int getPostiMacchina() {
        return postiMacchina;
    }

    public void setPostiMacchina(int postiMacchina) {
        this.postiMacchina = postiMacchina;
    }

    public int getPostiTenda() {
        return postiTenda;
    }

    public void setPostiTenda(int postiTenda) {
        this.postiTenda = postiTenda;
    }

    public int getPostiRoulotte() {
        return postiRoulotte;
    }

    public void setPostiRoulotte(int postiRoulotte) {
        this.postiRoulotte = postiRoulotte;
    }

    public String getRecapito() {
        return recapito;
    }

    public boolean getPernottamento() {
        return pernottamento;
    }
    public void isPrenotabile(boolean check){

        this.pernottamento = check;

    }

    public boolean isCamping() {
        return isCamping;
    }

    public void setCamping(boolean camping) {
        isCamping = camping;
    }

    public void setRecapito(String recapito) {
        this.recapito = recapito;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(denominazione + " di " + titolare + "\n" + indirizzo + "\n" + comune + "\n");
        if(postiLetto > 0)
            sb.append("Disponibili " + postiLetto + " posti letto.\n");
        if(postiMacchina > 0)
            sb.append("Disponibili posti " + postiMacchina + " auto.\n");
        if(postiTenda > 0)
            sb.append("Disponibili " + postiTenda + " posti tenda.\n");
        if(postiRoulotte > 0)
            sb.append("Disponibili " + postiRoulotte + " posti roulotte.\n");
        sb.append(recapito + "\n");
        sb.append(denominazione+" di " + titolare + "\n" + indirizzo + "\n" + comune + "\n");
        if(postiLetto > 0)
            sb.append("Disponibili "+ postiLetto +" posti letto.\n");
        if(postiMacchina > 0)
            sb.append("Disponibili posti " + postiMacchina + " auto.\n");
        if(postiTenda > 0)
            sb.append("Disponibili " + postiTenda + " posti tenda.\n");
        if(postiRoulotte > 0)
            sb.append("Disponibili " + postiRoulotte + " posti roulotte.\n");
        if(getPernottamento())
            sb.append("è possibile prenotare un posto \n");
        if(isCamping())
            sb.append("è possibile entrare nel campeggio\n");

        sb.append(recapito + "\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Agriturismo that = (Agriturismo) o;
        return Objects.equals(denominazione, that.denominazione);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(denominazione);
    }


}

