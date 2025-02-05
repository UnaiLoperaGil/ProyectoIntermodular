package ProyectoIntermodular;

//Unai Lopera Gil
//Tabla Producto y Tabla Consola

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String codProd;
        int PVP = 0;
        String modelo;
        String marca;
        boolean comprobarCodProd = false;
        boolean comprobarPVP = false;
        boolean comprobarModelo = false;
        boolean comprobarMarca = false;

        Scanner scan = new Scanner(System.in);
            do {
                System.out.println("Introduce el codProd: ");
                codProd = scan.nextLine();
                if(codProd.length()>30){
                    System.err.println("El tamaño del codProd ha excedido el límite de 30 caracteres");
                }
                else{
                    comprobarCodProd = true;
                }
            }while(!comprobarCodProd);

            do {
                try {
                    System.out.println("Introduce el PVP: ");
                    PVP = scan.nextInt();
                    scan.nextLine();
                    if (PVP < 0) {
                        System.err.println("El precio no puede ser negativo");
                    }
                    else{
                        comprobarPVP = true;
                    }
                } catch (InputMismatchException datoNoNumerico){
                    System.err.println("Se ha introducido un tipo de dato erróneo (Introduce un valor numérico entero)");
                    scan.next();
                }
            }while (!comprobarPVP);

            do{
                System.out.println("Introduce el modelo de la Consola: ");
                modelo = scan.nextLine();
                if(modelo.length()>20){
                    System.err.println("El tamaño del modelo ha excedido el límite de 20 caracteres");
                }
                else{
                    comprobarModelo = true;
                }
            }while (!comprobarModelo);

            do{
                System.out.println("Introduce la marca de la Consola: ");
                marca = scan.nextLine();
                if(marca.length()>20){
                    System.err.println("El tamaño de la marca ha excedido el límite de 20 caracteres");
                }
                else{
                    comprobarMarca = true;
                }
            }while (!comprobarMarca);

            Consola consola = new Consola(codProd, PVP, modelo, marca);

        System.out.println(" ");
        System.out.println("Objeto creado: ");
        System.out.println("CodProd: " + consola.getCodProd());
        System.out.println("PVP: " + consola.getPVP());
        System.out.println("Tipo: " + consola.getTipo());
        System.out.println("Modelo: " + consola.getModelo());
        System.out.println("Marca: " + consola.getMarca());

    }
}
