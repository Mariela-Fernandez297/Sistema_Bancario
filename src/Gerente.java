import java.util.Scanner;

public class Gerente extends Funcionario implements Autenticable
{
    public Gerente(String nombre, String documento, double salario, int tipo) {
        super(nombre, documento, salario, tipo);
    }


    @Override
    public void setClave(String password) {

    }

    @Override
    public boolean iniciarSesion(String clave, String username) {
        Scanner scanner = new Scanner(System.in);

        String correctUsername = "admin";
        String correctPassword = "password";

        System.out.print("Ingresa tu nombre de usuario: ");
        username = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        clave = scanner.nextLine();

        if (username.equals(correctUsername) && clave.equals(correctPassword)) {
            System.out.println("Bienvenido " + username + "! Has iniciado sesión correctamente.");
        }
        return false;
    }
}
