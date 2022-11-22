import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    //static Cajero newTitularuno = new Cajero();
    public static void main(String[] args) {
        Cajero newTitularuno = new Cajero();
        newTitularuno.setTitular("Danny Vinueza");
        newTitularuno.setSaldo(200.14);
        int op = 0;
        boolean pausa = false;
        while(!pausa){
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("\t\t****** MENU ******");
            System.out.println("\t1. Depositar");
            System.out.println("\t2. Retirar");
            System.out.println("\t3. Consulta de titular");
            System.out.println("\t4. Salir");
            System.out.print("\tOpcion?: ");
            op = sc.nextInt();
            switch(op){
                case 1:{
                    String inTitular;
                    System.out.println("Ha ingresado a la opcion depositar");
                    System.out.print("Ingrese el nombre del titular: ");
                    sc.nextLine();
                    inTitular = sc.nextLine();

                    if (inTitular.equals(newTitularuno.getTitular())){
                        mostrarTitular(newTitularuno);
                        depositar(newTitularuno);
                    }else{
                        System.out.println("Titular no ha sido registado");
                    }
                }break;
                case 2:{
                    String inTitular;
                    System.out.println("Ha ingresaado a la opcion retirar");
                    System.out.print("Ingrese el nombre del titular: ");
                    sc.nextLine();
                    inTitular = sc.nextLine();
                    if (inTitular.equals(newTitularuno.getTitular())){
                        mostrarTitular(newTitularuno);
                        retirar(newTitularuno);
                    }else{
                        System.out.println("Titular no ha sido registado");
                    }

                }break;
                case 3:{
                    System.out.println("Ha ingresado a la opcion mostrar");
                    mostrarTitular(newTitularuno);
                }break;
                case 4:{
                    System.out.println("Saliendo...");
                    pausa = true;
                }break;
            }
        }
    }

    public static void mostrarTitular(Cajero newTitular){
        System.out.println("\n\n-----------------------------------");
        System.out.println("Titular: " + newTitular.getTitular());
        System.out.println("Saldo: " + newTitular.getSaldo());
    }

    public static void depositar(Cajero newTitular){
        double inSaldo;
        System.out.print("Ingrese la cantidad a depositar: ");
        inSaldo = sc.nextDouble();
        newTitular.setSaldo((inSaldo + newTitular.getSaldo()));
        mostrarTitular(newTitular);
    }

    public static void retirar(Cajero newTitular){
        double reSaldo;
        System.out.print("Ingrese la cantidad a retirar: ");
        reSaldo = sc.nextDouble();
        if (reSaldo <= newTitular.getSaldo()){
            newTitular.setSaldo((newTitular.getSaldo()-reSaldo));
            mostrarTitular(newTitular);
        }else{
            System.out.println("Saldo no disponible");
        }
    }
}
