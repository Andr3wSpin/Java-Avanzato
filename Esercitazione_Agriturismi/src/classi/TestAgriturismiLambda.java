package classi;

public class TestAgriturismiLambda {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Napoli.csv");

        System.out.println(elencoAgriturismi);
    }
}
