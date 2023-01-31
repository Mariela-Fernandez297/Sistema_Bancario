public abstract class Funcionario
{
    protected String nombre;
    protected String documento;
    protected double salario;


    public Funcionario(String nombre, String documento, double salario)
    {
        this.nombre = nombre;
        this.documento = documento;
        this.salario = salario;
    }

    public abstract double getBonificacion();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", salario=" + salario +
                '}';
    }
}
