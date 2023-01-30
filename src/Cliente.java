public class Cliente
{
    private String nombre;
    private String documento;
    private String telefono;
    private AutenticacionUtil util;
    private Cuenta cuenta;

    public Cliente(String nombre, String documento, String telefono, String clave, int agencia, int numero, double saldo) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.util = new AutenticacionUtil();
        this.util.setClave(clave);
        this.cuenta.setAgencia(agencia);
        this.cuenta.setNumero(numero);;
        this.cuenta.setSaldo(saldo);
    }

    public AutenticacionUtil getUtil() {
        return util;
    }


    public String getNombre() {
        return nombre;
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
