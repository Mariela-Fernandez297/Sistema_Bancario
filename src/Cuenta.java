public class Cuenta
{
    private double saldo;
    private int agencia;
    private int numero;

    public Cuenta(double saldo,  int numero) {
        this.saldo = saldo;
        this.agencia = 1;
        this.numero = numero;
    }
    public Cuenta(int agen,int numero) {
        agencia=agen;
        this.numero=numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void depositar(double val) {

        saldo = saldo + val;

    }
    public boolean sacar(double val) {

        boolean realizado = false;

        if( val <= saldo) {
            saldo = saldo - val;
            realizado = true;
        }
        return realizado;
    }
    public boolean transferencia(double val, Cuenta cuenta) {

        boolean realizado=false;
        if(sacar(val)) {

            cuenta.depositar(val);
            realizado=true;
        }
        return realizado;

    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", agencia=" + agencia +
                ", numero=" + numero +
                '}';
    }
}
