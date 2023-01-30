public class Cuenta
{
    private double saldo;
    private int agencia;
    private int numero;

    public Cuenta(double saldo, int agencia, int numero) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
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

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", agencia=" + agencia +
                ", numero=" + numero +
                '}';
    }
}
