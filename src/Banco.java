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


    public Banco(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        in=new Scanner(System.in);
        this.listaFuncionarios = new ArrayList<>();
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
        System.out.println("----Menu de administracion----");
        System.out.println("[1] Registrar Admin");
        System.out.println("[2] Registrar Contador");
        System.out.println("[3] Registrar Gerente");
        System.out.println("[4] Registrar Cliente");
        System.out.println("[5] Mostrar funcionarios");
        System.out.println("[6] Mostrar clientes");
        System.out.println("[7] Editar funcionario");
        System.out.println("[8] Eliminar funcionario");
        System.out.println("[9] Eliminar Cliente");
        System.out.println("[10] Mostrar bonificaciones");
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
                case 3 -> registrarAdmin();

                case 0 -> System.out.println("El sistema se esta cerrando");
                default -> {
                }
            }

        } while(opcion!=0);

    }
    public void menuCliente(Cliente cliente) {

        System.out.println("[1] ver saldo");
        System.out.println("[2] Depositar monto a mi cuenta ");
        System.out.println("[3] Retirar monto ");
        System.out.println("[4] Transferir monto ");
        System.out.println("[5] Cambiar contraseña ");
        System.out.println("[0] Salir");

        int opcionesCliente = in.nextInt();
        int monto;
        String clave;

        switch (opcionesCliente)
        {
            case 1:
                System.out.println("Su saldo actual es: " + cliente.mostraSaldo());
                menuCliente(cliente);
                break;

            case 2 :
                System.out.print("Ingrese el monto a depositar: ");
                monto = in.nextInt();
                cliente.depositar(monto);
                menuCliente(cliente);
                break;

            case 3 :
                System.out.print("Ingrese el monto a retirar: ");
                monto = in.nextInt();
                cliente.retirar(monto);
                menuCliente(cliente);
                break;

            case 4:
                transferencia(cliente);
                menuCliente(cliente);
                break;
            case 5:

                System.out.print("Ingrese una nueva contraseña: ");
                clave = in.next();
                cliente.getUtil().setClave(clave);
                menuCliente(cliente);
                System.out.println("Contraseña modificada exitosamente!! \n");

            case 0: iniciar();

        }
    }
    private void registrarUsuario()
    {
        int opcion;
        do{
            menuRegistro();
            opcion=in.nextInt();

            switch (opcion)
            {
                case 1 -> registrarAdmin();
                case 2 -> registrarContador();
                case 3 -> registrarGerente();
                case 4 -> crearCuentaCliente();
                case 5 -> mostrarFuncionarios();
                case 6 -> mostrarClientes();
                case 7 -> editarFuncionario();
                case 8 -> eliminarFuncionario();
                case 9 -> eliminarCliente();
                case 10 -> mostrarBonificaciones();
                default -> {
                }
            }
        } while(opcion!=0);
    }
    private void mostrarBonificaciones()
    {
        for (int i = 0; i < listaFuncionarios.size(); i++)
        {
            System.out.println("Nombre: " + listaFuncionarios.get(i).nombre
                    + " Bonificación: " + listaFuncionarios.get(i).getBonificacion());
        }
    }
    private void mostrarFuncionarios()
    {
        for (int i = 0; i< listaFuncionarios.size(); i++)
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
        Cliente cliente;
        clave = in.next();
        for (int i = 0; i < listaClientes.size(); i++) {

            if(listaClientes.get(i) != null)
            {
                if(Objects.equals((listaClientes.get(i).getUtil().getClave()), clave))
                {
                    System.out.println("-----Bienvenido "+ listaClientes.get(i).getNombre()+"-----");
                    cliente = listaClientes.get(i);
                    menuCliente(cliente);
                }
            }
        }
    }


    private void identificarCredenciales()
    {
        System.out.print("Ingrese su contraseña : ");
        String clave;
        clave = in.next();
        Administrador mariela = new Administrador("Mariela","2222",2222,"123");
        listaFuncionarios.add(mariela);
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
    private void registrarAdmin()
    {
        String nombre, documento, clave;
        double salario;

        System.out.print("Ingrese su nombre: ");
        nombre = in.next();
        System.out.print("Ingrese su documento: ");
        documento = in.next();
        System.out.print("Ingrese su salario: ");
        salario = in.nextDouble();
        System.out.print("Ingrese su clave: ");
        clave = in.next();

        Administrador admin = new Administrador(nombre,documento,salario,clave);
        listaFuncionarios.add(admin);
        System.out.println("El registro fue exitoso!! \n");
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
        System.out.print("Ingrese el numero de cuenta: ");
        numeroCuenta = in.nextInt();
        System.out.print("Ingrese el saldo inicial: ");
        saldo = in.nextInt();

        Cliente cliente = new Cliente(nombre,documento,telefono,clave,numeroCuenta,saldo);
        listaClientes.add(cliente);
        System.out.println("El registro de cuenta fue exitoso!! \n");

    }

    private void registrarContador()
    {
        String nombre, documento;
        double salario;
        System.out.print("Ingrese su nombre: ");
        nombre = in.next();
        System.out.print("Ingrese su documento: ");
        documento = in.next();
        System.out.print("Ingrese su salario: ");
        salario = in.nextDouble();

        Contador contador = new Contador(nombre, documento, salario);
        listaFuncionarios.add(contador);
        System.out.println("\nEl registro fue exitoso!!");
    }
    private void registrarGerente()
    {
        String nombre, documento, clave;
        double salario;

        System.out.print("Ingrese su nombre: ");
        nombre = in.next();
        System.out.print("Ingrese su documento: ");
        documento = in.next();
        System.out.print("Ingrese su salario: ");
        salario = in.nextDouble();
        System.out.print("Ingrese una clave: ");
        clave = in.next();

        Gerente gerente = new Gerente(nombre, documento, salario, clave);
        listaFuncionarios.add(gerente);
        System.out.println("\nEl registro fue exitoso!!");
    }
    private void editarFuncionario()
    {
        String newNombre;
        String newDocumento;
        double newSalario;
        System.out.println("-----Editar-----\n");
        System.out.print("Ingresar el nombre actual:");
        nombre = in.next();

        for(int  i = 0; i < (long) listaFuncionarios.size() ; i++)
        {
            if (Objects.equals(listaFuncionarios.get(i).getNombre(), nombre))
            {
                System.out.print("Ingresar nuevo nombre: ");
                newNombre = in.next();
                System.out.print("Ingresar nuevo documento: ");
                newDocumento = in.next();
                System.out.print("Ingresar nueva salario: ");
                newSalario = in.nextDouble();

                listaFuncionarios.get(i).setNombre(newNombre);
                listaFuncionarios.get(i).setDocumento(newDocumento);
                listaFuncionarios.get(i).setSalario(newSalario);

                break;
            }
        }
    }

    private void eliminarFuncionario()
    {
        String nombre;
        System.out.print("-----Eliminar-----\n");
        System.out.print("Ingresar el nombre: ");
        nombre = in.next();

        for(int  i = 0; i < (long) listaFuncionarios.size() ; i++)
        {
            if (Objects.equals(listaFuncionarios.get(i).getNombre(), nombre))
            {
                listaFuncionarios.remove(i);
                System.out.println("Funcionario Eliminado exitosamente!!");
                break;
            }
        }
    }

    private void eliminarCliente()
    {
        String nombre;
        System.out.print("-----Eliminar-----\n");
        System.out.print("Ingresar el nombre: ");
        nombre = in.next();

        for(int  i = 0; i < (long) listaClientes.size() ; i++)
        {
            if (Objects.equals(listaClientes.get(i).getNombre(), nombre))
            {
                listaClientes.remove(i);
                System.out.println("Cliente Eliminado exitosamente!!");
                break;
            }
        }
    }



    public int buscarCliente(int numeroCuenta)
    {
        int aux;
        for (int i = 0; i <= listaClientes.size(); i++)
        {
            if (numeroCuenta == (listaClientes.get(i).getCuenta().getNumero()))
            {
                aux = i;
                return aux;
            }
        }
        return -1;
    }
    public void transferencia(Cliente cliente)
    {
        int montoSolicitado, numeroCuenta, posicion;

        System.out.print("Ingrese el monto a transferir: ");
        montoSolicitado = in.nextInt();

        System.out.print("Ingrese el numero de cuenta a transferir: ");
        numeroCuenta = in.nextInt();

        posicion = buscarCliente(numeroCuenta);

        if (cliente.mostraSaldo() > montoSolicitado)
        {
            if(posicion != -1)
            {
                cliente.retirar(montoSolicitado);
                listaClientes.get(posicion).depositar(montoSolicitado);
                System.out.println("Transferencia realizada exitosamente!!");
            }
            else
            {
                System.out.println("Nose encontro al Cliente");
            }
        }
        else
        {
            System.out.println("No tiene saldo suficiente");
        }
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
