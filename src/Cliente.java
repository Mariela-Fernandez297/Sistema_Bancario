public class Cliente
{
    private String nombre;
    private String documento;
    private String telefono;
    private AutenticacionUtil util;
    private Cuenta cuenta;

    public Cliente(String nombre, String documento, String telefono, String clave, int numero, double saldo) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.util = new AutenticacionUtil();
        this.util.setClave(clave);
        cuenta=new Cuenta(saldo,numero );
    }

    public AutenticacionUtil getUtil() {
        return util;
    }
    public String getNombre() {
        return nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void depositar(double depo)
    {
        cuenta.depositar(depo);
    }
    public void retirar(double reti)
    {
        cuenta.sacar(reti);
    }
    public void transferir(Cliente cliente, double monto)
    {

        cuenta.transferencia(monto, cliente.cuenta);
    }
    public double mostraSaldo() {
        return cuenta.getSaldo();
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
