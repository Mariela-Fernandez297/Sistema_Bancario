public class AutenticacionUtil
{
    private String clave;

    public AutenticacionUtil(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "AutenticacionUtil{" +
                "clave='" + clave + '\'' +
                '}';
    }
}
