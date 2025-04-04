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
        boolean opcionValida;

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
                    String antiguoCodProd;
                    do {
                        System.out.println("Introduce el CodProd de la consola que quieres actualizar: ");
                        antiguoCodProd = scanner.nextLine();
                    }while(!checkCodProd(antiguoCodProd));
                    Consola antigua = consolas.queryConsola(antiguoCodProd);
                    if(antigua != null){
                        System.out.println(textoVerde + "Introduce a continuación los datos actualizados" + resetColor);
                        Consola nueva = Crear.NuevaConsola();
                        if(consolas.updateConsola(antigua, nueva)){
                            System.out.println(textoVerde + "Se ha actualizado la consola correctamente" + resetColor);
                        }
                        else{
                            System.out.println(textoRojo + "No se ha podido actualizar la consola (comprueba que el CodProd introducido es válido)" + resetColor);
                        }
                    }
                    else{
                        System.out.println(textoRojo + "ERROR, consola no encontrada" + resetColor);
                    }
                    break;
                case 4:
                    String buscarCodProd;
                    do{
                        System.out.println("Introduce el CodProd de la consola que quieres buscar: ");
                        buscarCodProd = scanner.nextLine();
                    }while(!checkCodProd(buscarCodProd));
                    Consola busqueda = consolas.queryConsola(buscarCodProd);
                    if(busqueda != null){
                        System.out.println(textoVerde + "La información de la consola es la siguiente: " + resetColor);
                        System.out.println("Código: " + busqueda.getCodProd());
                        System.out.println("Precio: " + busqueda.getPVP() + "€");
                        System.out.println("Modelo: " + busqueda.getModelo());
                        System.out.println("Marca: " + busqueda.getMarca());
                    }
                    else {
                        System.out.println(textoRojo + "ERROR consola no encontrada" + resetColor);
                    }
                    break;
                case 5:
                    System.out.println(" ");
                    if(!consolas.printConsola()){
                        System.out.println(textoRojo + "Lista de Consolas vacía" + resetColor);
                    }
                    break;
                case 6:
                    System.out.println(" ");
                    if(consolas.generateXML()){
                        System.out.println(textoVerde + "XML generado correctamente en el archivo: consolas.xml" + resetColor);

                    }
                    break;
                case 0:
                    System.out.println(" ");
                    System.out.println(textoVerde + "Finalizando programa..." + resetColor);
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
        System.out.println("|     6 - Generar XML            |");
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
