package classi;

import java.security.AlgorithmParameterGenerator;
import java.util.List;
import java.util.function.Predicate;

public class MetodiAgriturismo {

    public void aggiornaPernottamento(Agriturismo agriturismo) {

        agriturismo.setPernottamento(true);
    }

    public void aggiornaCamping(Agriturismo agriturismo) {

        agriturismo.setCamping(true);
    }

    public boolean ospitaAgriturismo(Agriturismo agriturismo) {

        if (agriturismo.getDenominazione().isEmpty()) return false;

        return true;
    }

    public int ordinaPerNome(Agriturismo a1, Agriturismo a2) {

        return a1.getDenominazione().compareTo(a2.getDenominazione());
    }

    public int getPostiLettoComplessivi(List<Agriturismo> agriturismi) {

        int somma = 0;

        for (Agriturismo agriturismo : agriturismi) somma += agriturismo.getPostiLetto();

        return somma;
    }

    public boolean filtraPerComune(Agriturismo agriturismo) {

        return agriturismo.getComune().equals("GRAGNANO");
    }
}
