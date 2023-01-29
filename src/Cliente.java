public class Cliente
{
    private String nombre;
    private String documento;
    private String telefono;
    private AutenticacionUtil util;

    public Cliente(String nombre, String documento, String telefono, AutenticacionUtil util) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.util = util;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", util=" + util +
                '}';
    }
}
