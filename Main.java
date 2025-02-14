package ProyectoIntermodular;

//Unai Lopera Gil
//Tablas NuevaConsola y Producto

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String textoVerde = "\u001B[32m";
    public static final String textoRojo = "\u001B[31m";
    public static final String resetColor = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeConsola consolas = new ArrayDeConsola();
        boolean continuar = true;
        int opcion = 0;
        boolean opcionValida = false;

        while (continuar) {
            do {
                try {
                    System.out.println(" ");
                    imprimirMenu();
                    System.out.println("Elige una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    opcionValida = true;
                } catch (InputMismatchException opcionNoNumerica) {
                    System.out.println(textoRojo + "ERROR, la opción introducida no es numérica" + resetColor);
                    opcionValida = false;
                    scanner.nextLine();
                }
            } while (!opcionValida);

            switch(opcion){
                case 1:
                    Consola consolacreada = Crear.NuevaConsola();
                    boolean added = consolas.addNewConsola(consolacreada);
                    if(added){
                        System.out.println(textoVerde + "Se ha agregado la consola correctamente" + resetColor);
                    }
                    else{
                        System.out.println(textoRojo + "La consola que se quiere agregar tiene un CodProd ya existente" + resetColor);
                    }
                    break;
                case 2:
                    String eliminarCodProd;
                    do {
                        System.out.println("Introduce el CodProd que quieres eliminar: ");
                        eliminarCodProd = scanner.nextLine();
                    }while(!checkCodProd(eliminarCodProd));
                    Consola eliminar = consolas.queryConsola(eliminarCodProd);
                    if(eliminar != null) {
                        consolas.removeConsola(eliminar);
                        System.out.println(textoVerde + "La consola ha sido eliminada correctamente" + resetColor);
                    }
                    else{
                        System.out.println(textoRojo + "La consola introducida no existe" + resetColor);
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    consolas.printConsola();
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no considerada, vuelve a introducir");
            }

        }
    }

    public static void imprimirMenu(){
        System.out.println("+--------------------------------+");
        System.out.println("|         Menú Principal         |");
        System.out.println("+--------------------------------+");
        System.out.println("|     1 - Insertar Consola       |");
        System.out.println("|     2 - Eliminar Consola       |");
        System.out.println("|     3 - Actualizar Consola     |");
        System.out.println("|     4 - Consultar Consola      |");
        System.out.println("|     5 - Imprimir Consolas      |");
        System.out.println("|     0 - Salir del programa     |");
        System.out.println("+--------------------------------+");
    }

    public static boolean checkCodProd(String codProd) {
        if (codProd.length() > 30) {
            System.out.println(textoRojo + "El tamaño del codProd ha excedido el límite de 30 caracteres" + resetColor);
            return false;
        } else {
            return true;
        }
    }

}
