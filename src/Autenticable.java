public interface Autenticable
{
    void setClave(String password);
    boolean iniciarSesion(String clave, String username);
}
