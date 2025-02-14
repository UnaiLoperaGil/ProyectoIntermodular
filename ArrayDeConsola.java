package ProyectoIntermodular;

import java.util.ArrayList;

public class ArrayDeConsola{
    ArrayList<Consola> consolas = new ArrayList<>();

    public boolean addNewConsola(Consola agregar){
        if(findConsola(agregar.getCodProd())>=0){
            return false;
        }
        else{
            this.consolas.add(agregar);
            return true;
        }
    }

    public boolean removeConsola(Consola eliminar){
        if(findConsola(eliminar)>=0){
            this.consolas.remove(eliminar);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateConsola(Consola antigua, Consola nueva){
        int posicionAntigua = findConsola(antigua);
        if(posicionAntigua!=-1 && findConsola(nueva)==-1){
            this.consolas.set(posicionAntigua,nueva);
            System.out.println("Se ha actualizado la consola correctamente");
            return true;
        }
        else{
            System.out.println("No se ha podido actualizar la consola");
            return false;
        }
    }

    private int findConsola(Consola buscar){
        for (int i = 0; i<this.consolas.size(); i++){
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
        if(index>=0){
            return this.consolas.get(index);
        }
        else{
            return null;
        }
    }

    public void printConsola(){
        System.out.println("Lista de Consolas: ");
        for(int i = 0; i < this.consolas.size(); i++){
            System.out.println((i+1) + ". " + this.consolas.get(i).getCodProd() + " --> " + this.consolas.get(i).getModelo());
        }
    }
}




