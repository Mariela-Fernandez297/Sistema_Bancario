import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        public static void main(String[] args)
        {
            ArrayList<Funcionario> mylista = new ArrayList<Funcionario>();

            Administrador Mariela = new Administrador("mariela","8720430", 5000.0,3);

            Mariela.setClave("admin");

            mylista.add(Mariela);

            Banco banco = new Banco("Facil", "Simon lopez", mylista);
            banco.iniciar();

        }
}