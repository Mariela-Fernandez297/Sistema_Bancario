public interface IAutenticable
{
    void setClave(String password);
    boolean iniciarSesion(String clave);
}
