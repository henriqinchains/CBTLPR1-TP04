package tp04;

/**
 *
 * @author henri
 */
public class TP04 {

    public static void main(String[] args) {

        Data d1 = new Data();

        System.out.println("\n===== DATA 1 =====");

        System.out.println("Formato 1: " + d1.mostra1());

        System.out.println("Formato 2: " + d1.mostra2());

        System.out.println("Ano bissexto: " + d1.bissexto());

        System.out.println("Dias transcorridos: " + d1.diasTranscorridos());

        System.out.print("Data atual: ");
        d1.apresentaDataAtual();

        Data d2 = new Data(15, 8, 2024);

        System.out.println("\n===== DATA 2 =====");

        System.out.println("Formato 1: " + d2.mostra1());

        System.out.println("Formato 2: " + d2.mostra2());

        System.out.println("Ano bissexto: " + d2.bissexto());

        System.out.println("Dias transcorridos: " + d2.diasTranscorridos());

        d2.entraDia(25);
        d2.entraMes(12);
        d2.entraAno(2028);

        System.out.println("\n===== DATA 2 ALTERADA =====");

        System.out.println("Formato 1: " + d2.mostra1());

        System.out.println("Formato 2: " + d2.mostra2());

        System.out.println("Ano bissexto: " + d2.bissexto());

        System.out.println("Dias transcorridos: " + d2.diasTranscorridos());

        System.out.print("Data atual: ");
        d2.apresentaDataAtual();
    }

}
