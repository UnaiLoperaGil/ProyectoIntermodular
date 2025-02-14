package ProyectoIntermodular;
//Unai Lopera Gil
//Tabla Producto y Tabla NuevaConsola

public class Producto {
    private String codProd; //Maximo 30 caracteres
    private int PVP; //Debería haber sido tipo double, mayor que 0
    private String tipo; //Solo puede tener valores "NuevaConsola" y "Juego"

    public Producto(String codProd, int PVP, String tipo) {
        this.codProd = codProd;
        this.PVP = PVP;
        this.tipo = tipo;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
            this.codProd = codProd;
    }

    public int getPVP() {
        return PVP;
    }

    public void setPVP(int PVP) {
        this.PVP = PVP;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codProd='" + codProd + '\'' +
                ", PVP=" + PVP +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
