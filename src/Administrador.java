import java.util.Scanner;

public class Administrador extends Funcionario implements IAutenticable {
    private AutenticacionUtil util;

    public Administrador(String nombre, String documento, double salario, int tipo) {
        super(nombre, documento, salario, tipo);
        this.util = new AutenticacionUtil();
    }

    @Override
    public double getBonificacion() {
        return salario * 0.06;
    }


    @Override
    public void setClave(String clave) {
        this.util.setClave(clave);
    }


    public AutenticacionUtil getUtil() {
        return util;
    }

    @Override
    public boolean iniciarSesion(String clave) {

        if (clave.equals(this.util.getClave())) {
            System.out.println("Bienvenido " + nombre + "! Has iniciado sesión correctamente.");
            return  true;
        }
        else {
            System.out.println("Error en clave");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "util=" + util +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", salario=" + salario +
                ", tipo=" + tipo +
                '}';
    }
}
