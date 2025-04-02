package classi;

import java.util.Set;

public class TestAgriturismiReference {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Napoli.csv");

        //System.out.println(elencoAgriturismi);

        MetodiAgriturismo ma = new MetodiAgriturismo();

        elencoAgriturismi.aggiorna(ma::aggiornaPernottamento);
        elencoAgriturismi.aggiorna(ma::aggiornaCamping);

        ElencoAgriturismi e2 =  elencoAgriturismi.filtra(agriturismo -> agriturismo.isCamping());

        //System.out.println(e2);

        Set<String> comuni = e2.esporta(ma::ospitaAgriturismo);

        //System.out.println(comuni);

        e2.ordina(ma::ordinaPerNome);

        //System.out.println(e2);
    }
}
