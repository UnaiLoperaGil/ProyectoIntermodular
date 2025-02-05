package ProyectoIntermodular;

//Unai Lopera Gil
//Tabla Producto y Tabla Consola

public class Consola extends Producto{
    private String modelo;
    private String marca;

    public Consola(String codProd, int PVP, String modelo, String marca) {
        super(codProd, PVP, "Consola");
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Consola{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
