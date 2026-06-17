package tp04;

import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author henri
 */
public class Data {

    Scanner scanner = new Scanner(System.in);

    private int dia;
    private int mes;
    private int ano;

    public Data() {
        entraAno();
        entraMes();
        entraDia();
    }

    public Data(int d, int m, int a) {
        entraAno(a);
        entraMes(m);
        entraDia(d);
    }

    public void entraAno(int a) {

        if (a >= 1) {
            ano = a;
        } else {
            System.out.println("Ano invalido!");
        }
    }

    public void entraMes(int m) {

        if (m >= 1 && m <= 12) {
            mes = m;
        } else {
            System.out.println("Mes invalido!");
        }
    }

    public void entraDia(int d) {

        if (d >= 1 && d <= diasNoMes(mes, ano)) {
            dia = d;
        } else {
            System.out.println("Dia invalido!");
        }
    }

    public void entraAno() {

        while (true) {

            System.out.print("Digite o ano: ");

            if (scanner.hasNextInt()) {

                int a = scanner.nextInt();

                if (a >= 1) {
                    ano = a;
                    break;
                } else {
                    System.out.println("Ano invalido. Digite novamente.");
                }
            } else {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
                scanner.next();
            }
        }
    }

    public void entraMes() {

        while (true) {

            System.out.print("Digite o mes: ");

            if (scanner.hasNextInt()) {

                int m = scanner.nextInt();

                if (m >= 1 && m <= 12) {
                    mes = m;
                    break;
                } else {
                    System.out.println("Mes invalido. Digite novamente.");
                }
            } else {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
                scanner.next();
            }
        }
    }

    public void entraDia() {

        while (true) {

            System.out.print("Digite o dia: ");

            if (scanner.hasNextInt()) {

                int d = scanner.nextInt();

                if (d >= 1 && d <= diasNoMes(mes, ano)) {
                    dia = d;
                    break;
                } else {
                    System.out.println("Dia invalido. Digite novamente.");
                }
            } else {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
                scanner.next();
            }
        }
    }

    public int retDia() {
        return dia;
    }

    public int retMes() {
        return mes;
    }

    public int retAno() {
        return ano;
    }

    public String mostra1() {

        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String mostra2() {

        String[] meses = {
            "Janeiro", "Fevereiro", "Marco", "Abril",
            "Maio", "Junho", "Julho", "Agosto",
            "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        return String.format("%02d/%s/%04d",
                dia, meses[mes - 1], ano);
    }

    public boolean bissexto() {

        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) {
            return true;
        }

        return false;
    }

    public int diasTranscorridos() {

        int[] diasMes = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        if (bissexto()) {
            diasMes[1] = 29;
        }

        int total = dia;

        for (int i = 0; i < mes - 1; i++) {
            total += diasMes[i];
        }

        return total;
    }

    public void apresentaDataAtual() {

        Date hoje = new Date();

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(df.format(hoje));
    }

    private int diasNoMes(int mes, int ano) {

        switch (mes) {

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            case 2:

                if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) {
                    return 29;
                }

                return 28;

            default:
                return 0;
        }
    }
}
