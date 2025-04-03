package classi;

import java.util.Set;

public class TestAgriturismiReference {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Napoli.csv");

        //System.out.println(elencoAgriturismi);

        MetodiAgriturismo ma = new MetodiAgriturismo();

        elencoAgriturismi.aggiorna(ma::aggiornaPernottamento);
        elencoAgriturismi.aggiorna(ma::aggiornaCamping);

        Set<String> comuni = elencoAgriturismi.esporta(ma::ospitaAgriturismo);

        //System.out.println(comuni);

        elencoAgriturismi.ordina(ma::ordinaPerNome);

        ElencoAgriturismi e2 = elencoAgriturismi.filtra(ma::filtraPerComune);

        int somma = e2.somma(Agriturismo::getPostiLetto) ;

        System.out.println(somma);
    }
}
