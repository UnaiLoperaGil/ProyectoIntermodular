package ProyectoIntermodular;

import java.util.ArrayList;

public class ArrayDeConsola{
    ArrayList<Consola> consolas = new ArrayList<>();

    public boolean addNewConsola(Consola agregar){
        if(findConsola(agregar.getCodProd()) >= 0){
            return false;
        }
        else{
            this.consolas.add(agregar);
            return true;
        }
    }

    public boolean removeConsola(Consola eliminar){
        if(findConsola(eliminar) >= 0){
            this.consolas.remove(eliminar);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateConsola(Consola antigua, Consola nueva){
        int posicionAntigua = findConsola(antigua.getCodProd());
        if(posicionAntigua != -1 && findConsola(nueva.getCodProd()) == -1){
            this.consolas.set(posicionAntigua,nueva);
            return true;
        }
        else{
            return false;
        }
    }

    private int findConsola(Consola buscar){
        for (int i = 0; i < this.consolas.size(); i++){
            if(this.consolas.get(i).equals(buscar)){
                return i;
            }
        }
        return -1;
    }

    private int findConsola(String codProd){
        for (int i = 0; i<consolas.size(); i++){
            if(consolas.get(i).getCodProd().equalsIgnoreCase(codProd)){
                return i;
            }
        }
        return -1;
    }

    public Consola queryConsola(String codProd){
        int index = findConsola(codProd);
        if(index >= 0){
            return this.consolas.get(index);
        }
        else{
            return null;
        }
    }

    public boolean generateXML(){
        if (this.consolas.isEmpty()){
            return false;
        } else{
                System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                System.out.println("<Consolas>");

                for (Consola consola : consolas) {
                    System.out.println("  <Consola>");
                    System.out.println("    <CodProd>" + consola.getCodProd() + "</CodProd>");
                    System.out.println("    <PVP>" + consola.getPVP() + "</PVP>");
                    System.out.println("    <Modelo>" + consola.getModelo() + "</Modelo>");
                    System.out.println("    <Marca>" + consola.getMarca() + "</Marca>");
                    System.out.println("  </Consola>");
                }

                System.out.println("</Consolas>");
                System.out.println();
            }
            return true;
        }

    public boolean printConsola() {
        if (this.consolas.isEmpty()) {
            return false;
        } else {
            System.out.println("Lista de Consolas:");
            System.out.println("----------------------------------");
            for (int i = 0; i < this.consolas.size(); i++) {
                System.out.println((i + 1) + ". Código: " + this.consolas.get(i).getCodProd());
                System.out.println("   Precio: " + this.consolas.get(i).getPVP() + "€");
                System.out.println("   Modelo: " + this.consolas.get(i).getModelo());
                System.out.println("   Marca: " + this.consolas.get(i).getMarca());
                System.out.println("----------------------------------");
            }
            return true;
        }
    }

}




