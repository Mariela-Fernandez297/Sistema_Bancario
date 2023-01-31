public class Contador extends Funcionario
{

    public Contador(String nombre, String documento, double salario)
    {
        super(nombre, documento, salario);
    }

    @Override
    public double getBonificacion() {
        return salario * 0.01 ;
    }


    @Override
    public String toString() {
        return "Contador{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", salario=" + salario +
                '}';
    }
}
