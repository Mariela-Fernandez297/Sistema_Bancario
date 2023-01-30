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
    private ArrayList<Cliente>listaClientes;


    public Banco(String nombre, String direccion, ArrayList<Funcionario> listaFuncionarios) {
        this.nombre = nombre;
        this.direccion = direccion;
        in=new Scanner(System.in);
        this.listaFuncionarios = listaFuncionarios;
        this.listaClientes = new ArrayList<>();
    }
    public void menuPrincial()
    {
        System.out.println("----Bienvenidos al sistema bancario "+ nombre + "----");
        System.out.println("[1] Iniciar sesion funcionario");
        System.out.println("[2] Iniciar sesion cliente");
        System.out.println("[0] Salir");
    }
    public void menuRegistro()
    {
        System.out.println("----Registro de usuarios----");
        System.out.println("[1] Registrar Contador");
        System.out.println("[2] Registrar Gerente");
        System.out.println("[3] Registrar Cliente");
        System.out.println("[4] Mostrar funcionarios");
        System.out.println("[5] Mostrar clientes");
        System.out.println("[6] Mostrar bonificaciones");
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
                case 1 -> identificarCredenciales();
                case 2 -> credencialCliente();

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
                case 3 -> crearCuentaCliente();
                case 4 -> mostrarFuncionarios();
                case 5 -> mostrarClientes();
                case 6 -> mostrarBonificaciones();
                default -> {
                }
            }
        } while(opcion!=0);
    }
    private void mostrarBonificaciones()
    {
        for (int i = 0; i < listaFuncionarios.size(); i++)
        {
            System.out.println(listaFuncionarios.get(i).getBonificacion());

        }

    }
    private void mostrarFuncionarios()
    {
        for (int i = 0; i< (long) listaFuncionarios.size(); i++)
        {
            System.out.println(listaFuncionarios.get(i));
        }
    }
    private void mostrarClientes()
    {
        for (int i = 0; i < listaClientes.size();  i++)
        {
            System.out.println(listaClientes.get(i));

        }
    }
    private void credencialCliente()
    {
        System.out.print("Ingrese su contraseña : ");
        String clave;
        clave = in.next();
        for (int i = 0; i < listaClientes.size(); i++) {

            if(listaClientes.get(i) != null)
            {
                if(Objects.equals((listaClientes.get(i).getUtil().getClave()), clave))
                {
                    System.out.println("-----Bienvenido "+ listaClientes.get(i).getNombre()+"-----");
                    String contra;
                    System.out.print("Nueva contraseña: ");
                    contra = in.next();
                    listaClientes.get(i).getUtil().setClave(contra);
                }
            }
        }
    }

    private void identificarCredenciales()
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
                    break;
                }
            }
        }
    }

    private void crearCuentaCliente()
    {
        String nombre, documento, telefono, clave;
        int numeroCuenta, agencia;
        double saldo;

        System.out.print("Ingrese su nombre: ");
        nombre = in.next();
        System.out.print("Ingrese su documento: ");
        documento = in.next();
        System.out.print("Ingrese su telefono: ");
        telefono = in.next();
        System.out.print("ingrese su clave: ");
        clave = in.next();
        System.out.println("ingrese el numero de agencia: ");
        agencia = in.nextInt();
        System.out.print("Ingrese el numero de cuenta: ");
        numeroCuenta = in.nextInt();
        System.out.println("Ingrese el saldo inicial: ");
        saldo = in.nextInt();

        Cliente cliente = new Cliente(nombre,documento,telefono,clave,agencia,numeroCuenta,saldo);
        listaClientes.add(cliente);

    }

    private void registrarContador()
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
    private void registrarGerente()
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
