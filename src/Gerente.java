import java.util.Scanner;

public class Gerente extends Funcionario implements IAutenticable
{
    private String clave;

    public Gerente(String nombre, String documento, double salario, String clave)
    {
        super(nombre, documento, salario);
        this.clave = clave;
    }

    @Override
    public double getBonificacion()
    {
        return salario * 0.1;
    }


    @Override
    public void setClave(String clave)
    {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    @Override
    public boolean iniciarSesion(String clave) {

        if (clave.equals(this.clave)) {
            System.out.println("Bienvenido " + nombre + "! Has iniciado sesión correctamente.");
            return true;
        }
        else {
            System.out.println("Error de contraseña");
            return false;
        }

    }

    @Override
    public String toString() {
        return "Gerente{" +
                "clave='" + clave + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", salario=" + salario +
                '}';
    }
}
