package tp04;

import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

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
        if (dataValida(d,m,a)) {
            ano=a; mes=m; dia=d;
        } else {
            System.out.println("Data invalida!");
        }
    }

    public void entraAno(int a){
        if(a>=1 && dataValida(dia==0?1:dia, mes==0?1:mes, a)) ano=a;
        else System.out.println("Ano invalido!");
    }

    public void entraMes(int m){
        if(m>=1 && m<=12 && dataValida(dia==0?1:dia,m,ano==0?1:ano)) mes=m;
        else System.out.println("Mes invalido!");
    }

    public void entraDia(int d){
        if(dataValida(d,mes,ano)) dia=d;
        else System.out.println("Dia invalido!");
    }

    public void entraAno(){
        while(true){
            System.out.print("Digite o ano: ");
            if(scanner.hasNextInt()){
                int a=scanner.nextInt();
                if(a>=1){ano=a;break;}
            } else scanner.next();
            System.out.println("Ano invalido. Digite novamente.");
        }
    }

    public void entraMes(){
        while(true){
            System.out.print("Digite o mes: ");
            if(scanner.hasNextInt()){
                int m=scanner.nextInt();
                if(m>=1&&m<=12){mes=m;break;}
            } else scanner.next();
            System.out.println("Mes invalido. Digite novamente.");
        }
    }

    public void entraDia(){
        while(true){
            System.out.print("Digite o dia: ");
            if(scanner.hasNextInt()){
                int d=scanner.nextInt();
                if(dataValida(d,mes,ano)){dia=d;break;}
            } else scanner.next();
            System.out.println("Dia invalido. Digite novamente.");
        }
    }

    public int retDia(){return dia;}
    public int retMes(){return mes;}
    public int retAno(){return ano;}

    public String mostra1(){
        return String.format("%02d/%02d/%04d",dia,mes,ano);
    }

    public String mostra2(){
        String[] meses={"Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        return String.format("%02d/%s/%04d",dia,meses[mes-1],ano);
    }

    public boolean bissexto(){
        return (ano%400==0)||(ano%4==0&&ano%100!=0);
    }

    public int diasTranscorridos(){
        int[] d={31,28,31,30,31,30,31,31,30,31,30,31};
        if(bissexto()) d[1]=29;
        int t=dia;
        for(int i=0;i<mes-1;i++) t+=d[i];
        return t;
    }

    public void apresentaDataAtual(){
        Date hoje=new Date();
        DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(hoje));
    }

    private boolean dataValida(int d,int m,int a){
        if(a<1||m<1||m>12) return false;
        return d>=1&&d<=diasNoMes(m,a);
    }

    private int diasNoMes(int m,int a){
        switch(m){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:return 31;
            case 4:case 6:case 9:case 11:return 30;
            case 2:return ((a%400==0)||(a%4==0&&a%100!=0))?29:28;
            default:return 0;
        }
    }
}
