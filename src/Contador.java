public class Contador extends Funcionario
{
    public Contador(String nombre, String documento, double salario, int tipo) {
        super(nombre, documento, salario, tipo);
    }


    @Override
    public String toString() {
        return "Contador{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", salario=" + salario +
                ", tipo=" + tipo +
                '}';
    }
}
