import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Banco
{
    private String nombre;
    private String direccion;
    private Scanner in;
    private ArrayList<Funcionario>listaFuncionarios;


    public Banco(String nombre, String direccion, ArrayList<Funcionario> listaFuncionarios) {
        this.nombre = nombre;
        this.direccion = direccion;
        in=new Scanner(System.in);
        this.listaFuncionarios = listaFuncionarios;
    }
    public void menuPrincial()
    {
        System.out.println("----Bienvenidos al sistema bancario "+ nombre + "----");
        System.out.println("[1] Iniciar sesion");
        System.out.println("[2] Mostrar bonificacion del contador");
        System.out.println("[0] Salir");
    }
    public void menuRegistro()
    {
        System.out.println("----Registro de usuarios----");
        System.out.println("[1] Registrar Contador");
        System.out.println("[2] Registrar Gerente");
        System.out.println("[3] Registrar Cliente");
        System.out.println("[4] Mostrar usuarios");
        System.out.println("[0] Salir");
    }
    public void iniciar()
    {
        int opcion;

        do{
            menuPrincial();
            opcion = in.nextInt();
            switch (opcion)
            {
                case 1 -> {
                    identificarCredenciales();
                }
                case 0 -> System.out.println("El sistema se esta cerrando");
                default -> {
                }
            }

        } while(opcion!=0);

    }
    private void registrarUsuario()
    {
        int opcion;
        do{
            menuRegistro();
            opcion=in.nextInt();

            switch (opcion)
            {
                case 1 -> registrarContador();
                case 2 -> registrarGerente();
                case 3 -> registrarCliente();
                case 4 -> mostrarUsuarios();
                default -> {
                }
            }
        } while(opcion!=0);


    }
    public void mostrarUsuarios()
    {
        for (int i = 0; i< (long) listaFuncionarios.size(); i++)
        {
            System.out.println(listaFuncionarios.get(i));
        }
    }

    public void identificarCredenciales()
    {
        System.out.print("Ingrese su contraseña : ");
        String clave;
        clave = in.next();

        for (int i = 0; i < listaFuncionarios.size(); i++) {

            if (listaFuncionarios.get(i) instanceof Administrador )
            {
                if (Objects.equals(((Administrador) listaFuncionarios.get(i)).getUtil().getClave(), clave))
                {
                    registrarUsuario();

                    break;
                }
            }

            else if (listaFuncionarios.get(i) instanceof Gerente)
            {
                if (Objects.equals(((Gerente) listaFuncionarios.get(i)).getClave(), clave))
                {
                    System.out.println("-----Bienvenido "+ listaFuncionarios.get(i).getNombre()+"-----");
                    String contra;
                    System.out.print("Nueva contraseña: ");
                    contra = in.next();
                    ((Gerente) listaFuncionarios.get(i)).setClave(contra);
                }
            }
        }
    }
    public void cambiarContrasena()
    {
        System.out.println("----Cambiar Contraseña----");
        System.out.println("1. Nueva contraseña: ");
        System.out.println("0. Salir");
    }
    public void registrarCliente()
    {

    }


    public void registrarContador()
    {
        String nombre, documento;
        int tipo;
        double salario;
        System.out.print("Ingrese su nombre: ");
        nombre = in.next();
        System.out.print("Ingrese su documento: ");
        documento = in.next();
        System.out.print("Ingrese su salario: ");
        salario = in.nextDouble();
        System.out.print("Ingrese el tipo: ");
        tipo = in.nextInt();

        Contador contador = new Contador(nombre, documento, salario, tipo);
        listaFuncionarios.add(contador);
    }
    public void registrarGerente()
    {
        String nombre, documento, clave;
        int tipo;
        double salario;
        System.out.print("Ingrese su nombre: ");
        nombre = in.next();
        System.out.print("Ingrese su documento: ");
        documento = in.next();
        System.out.print("Ingrese su salario: ");
        salario = in.nextDouble();
        System.out.print("Ingrese el tipo: ");
        tipo = in.nextInt();
        System.out.print("Ingrese una clave: ");
        clave = in.next();
        Gerente gerente = new Gerente(nombre, documento, salario, tipo, clave);
        listaFuncionarios.add(gerente);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
