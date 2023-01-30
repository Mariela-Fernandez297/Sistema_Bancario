public class AutenticacionUtil
{
   private String clave;

   public void setClave(String clave)
   {
       this.clave = clave;
   }

    public String getClave() {
        return clave;
    }

    public boolean iniciarSesion(String clave)
   {
       return this.clave == clave ? true : false ;
   }

    @Override
    public String toString() {
        return "AutenticacionUtil{" +
                "clave='" + clave + '\'' +
                '}';
    }
}
